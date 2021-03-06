package com.aristotle.core.persistance;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.aristotle.core.enums.ContentStatus;

@Entity
@Table(name="videos")
public class Video extends BaseEntity {

	@Column(name = "title")
	private String title; // Title of the news/post item
	@Column(name = "image_url")
	private String imageUrl;// image preview url for this news item
	@Column(name = "web_url", length=256)
	private String webUrl;// Web url link for this news, which will be shared by share intent
	@Column(name = "publish_date")
	private Date publishDate;//Publish date of this item
	@Column(name = "description", columnDefinition="LONGTEXT")
	private String description;//description of video
	@Column(name = "utube_video_id")
	private String youtubeVideoId;
	@Column(name = "channel_id")
	private String channelId;

	@Column(name = "global_allowed")
	private boolean global;//Whether this News is available global or not

	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "video_tweets",
	joinColumns = {
	@JoinColumn(name="video_id") 
	},
	inverseJoinColumns = {
	@JoinColumn(name="content_tweet_id")
	})
	private List<ContentTweet> tweets;//all one liners attached to this news which can be tweeted
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "video_ac",
	joinColumns = {
	@JoinColumn(name="video_id") 
	},
	inverseJoinColumns = {
	@JoinColumn(name="ac_id")
	})
	private List<AssemblyConstituency> assemblyConstituencies;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "video_pc",
	joinColumns = {
	@JoinColumn(name="video_id") 
	},
	inverseJoinColumns = {
	@JoinColumn(name="pc_id")
	})
	private List<ParliamentConstituency> parliamentConstituencies;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "video_district",
	joinColumns = {
	@JoinColumn(name="video_id") 
	},
	inverseJoinColumns = {
	@JoinColumn(name="district_id")
	})
	private List<District> districts;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "video_state",
	joinColumns = {
	@JoinColumn(name="video_id") 
	},
	inverseJoinColumns = {
	@JoinColumn(name="state_id")
	})
    private List<State> states;
	
	
	@ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "video_location",
    joinColumns = {
    @JoinColumn(name="video_id") 
    },
    inverseJoinColumns = {
    @JoinColumn(name="location_id")
    })
    private List<Location> locations;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "video_country",
	joinColumns = {
	@JoinColumn(name="video_id") 
	},
	inverseJoinColumns = {
	@JoinColumn(name="country_id")
	})
	private List<Country> countries;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "video_country_region",
	joinColumns = {
	@JoinColumn(name="video_id") 
	},
	inverseJoinColumns = {
	@JoinColumn(name="country_region_id")
	})
	private List<CountryRegion> countryRegions;
	
	@Column(name = "content_status", nullable = false)
	@Enumerated(EnumType.STRING)
	private ContentStatus contentStatus;

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getWebUrl() {
		return webUrl;
	}
	public void setWebUrl(String webUrl) {
		this.webUrl = webUrl;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	public List<ContentTweet> getTweets() {
		return tweets;
	}
	public void setTweets(List<ContentTweet> tweets) {
		this.tweets = tweets;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getYoutubeVideoId() {
		return youtubeVideoId;
	}
	public void setYoutubeVideoId(String youtubeVideoId) {
		this.youtubeVideoId = youtubeVideoId;
	}
	public boolean isGlobal() {
		return global;
	}
	public void setGlobal(boolean global) {
		this.global = global;
	}
	public List<AssemblyConstituency> getAssemblyConstituencies() {
		return assemblyConstituencies;
	}
	public void setAssemblyConstituencies(List<AssemblyConstituency> assemblyConstituencies) {
		this.assemblyConstituencies = assemblyConstituencies;
	}
	public List<ParliamentConstituency> getParliamentConstituencies() {
		return parliamentConstituencies;
	}
	public void setParliamentConstituencies(List<ParliamentConstituency> parliamentConstituencies) {
		this.parliamentConstituencies = parliamentConstituencies;
	}
	public List<District> getDistricts() {
		return districts;
	}
	public void setDistricts(List<District> districts) {
		this.districts = districts;
	}
	public List<State> getStates() {
		return states;
	}
	public void setStates(List<State> states) {
		this.states = states;
	}
	public ContentStatus getContentStatus() {
		return contentStatus;
	}
	public void setContentStatus(ContentStatus contentStatus) {
		this.contentStatus = contentStatus;
	}
	public List<Country> getCountries() {
		return countries;
	}
	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}
	public List<CountryRegion> getCountryRegions() {
		return countryRegions;
	}
	public void setCountryRegions(List<CountryRegion> countryRegions) {
		this.countryRegions = countryRegions;
	}
	public String getChannelId() {
		return channelId;
	}
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }
}
