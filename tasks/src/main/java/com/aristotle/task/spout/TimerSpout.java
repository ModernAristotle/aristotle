package com.aristotle.task.spout;

import java.util.Map;

import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.tuple.Values;

import com.aristotle.task.topology.SpringAwareBaseSpout;
import com.aristotle.task.topology.beans.Stream;

/**
 * Created by Ravi Sharma on 01/07/2015.
 */
public class TimerSpout extends SpringAwareBaseSpout {

    private long lastTime = 0;
    private long durationMs;
    private boolean onStart;
    private Stream outputStream;
    @Override
    public void onOpen(Map conf, TopologyContext context, SpoutOutputCollector collector) {
        if(!onStart){
            lastTime = System.currentTimeMillis();
        }
    }

    @Override
    public void nextTuple() {
        Long currentTime = System.currentTimeMillis();
        if(currentTime - lastTime >= durationMs){
            emitTuple(outputStream.getStreamId(), new Values("default"));
            lastTime = currentTime;
        }
        sleepForMilliSeconds(durationMs - (currentTime - lastTime));
    }

    public long getDurationMs() {
        return durationMs;
    }

    public void setDurationMs(long durationMs) {
        this.durationMs = durationMs;
    }

    public boolean isOnStart() {
        return onStart;
    }

    public void setOnStart(boolean onStart) {
        this.onStart = onStart;
    }

    public Stream getOutputStream() {
        return outputStream;
    }

    public void setOutputStream(Stream outputStream) {
        this.outputStream = outputStream;
    }

    @Override
    protected void onAck(Object msgId) {
    }

    @Override
    protected void onFail(Object msgId) {
    }

    @Override
    public void onLastFail(Object msgId) {

    }

}
