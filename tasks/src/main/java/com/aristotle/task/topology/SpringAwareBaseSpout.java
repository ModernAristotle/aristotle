package com.aristotle.task.topology;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import backtype.storm.tuple.Fields;
import com.aristotle.task.topology.beans.Stream;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;

import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.IRichSpout;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.tuple.Values;

import com.aristotle.task.spring.SpringContext;

public abstract class SpringAwareBaseSpout extends BaseComponent implements IRichSpout {

	private static final long serialVersionUID = 1L;


    protected String componentId;
    private int maxSpoutPending;
    private Map<String, Object> config;
    private SpoutOutputCollector collector;

    @Override
    public final void open(Map conf, TopologyContext context, SpoutOutputCollector collector) {
        SpringContext.getContext().getAutowireCapableBeanFactory().autowireBeanProperties(this, AutowireCapableBeanFactory.AUTOWIRE_AUTODETECT, false);
        this.config = conf;
        this.collector = collector;
        onOpen(conf, context, collector);
    }

    public abstract void onOpen(Map conf, TopologyContext context, SpoutOutputCollector collector);

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        Field[] classFields = this.getClass().getFields();
        for(Field oneClassField : classFields){
            if(oneClassField.getType().isAssignableFrom(Stream.class)){
                Fields fields = new Fields("default");
                Stream stream = (Stream)oneClassField.get();
                if(stream.getFields() != null && !stream.getFields().isEmpty()){

                }
                declarer.declareStream(outputStream, fields);

            }
        }
    }

    protected void emitTuple(String streamName, Values values) {
        collector.emit(streamName, values);
    }

    protected MessageId<List<Object>> writeToStream(List<Object> tuple) {
        MessageId<List<Object>> messageId = new MessageId<>();
        messageId.setData(tuple);
        // writeToStream(tuple, messageId);
        return messageId;
    }


    public String getComponentId() {
        return componentId;
    }

    public void setComponentId(String componentId) {
        this.componentId = componentId;
    }

    @Override
    public void close() {
        super.destroy();
    }

    @Override
    public void activate() {

    }

    @Override
    public void deactivate() {

    }

    @Override
    public void ack(Object msgId) {

    }

    @Override
    public void fail(Object msgId) {

    }

    @Override
    public Map<String, Object> getComponentConfiguration() {
        return config;
    }

    public int getMaxSpoutPending() {
        return maxSpoutPending;
    }

    public void setMaxSpoutPending(int maxSpoutPending) {
        this.maxSpoutPending = maxSpoutPending;
    }

}