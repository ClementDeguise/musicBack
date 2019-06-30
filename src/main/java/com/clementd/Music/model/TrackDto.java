package com.clementd.Music.model;


/** Track Data Transfer Object
 * A DTO is an object representing or not the initial object, here a track, that we will send back as the response to the request,
 * to notify the front that we saved the track, with these information. The information may differ according to the front need
 *
 */


public class TrackDto {

    private String fileName;
    private String fileDownloadUri;
    private String fileType;
    private long size;

    public TrackDto(String fileName, String fileDownloadUri, String fileType, long size) {
        this.fileName = fileName;
        this.fileDownloadUri = fileDownloadUri;
        this.fileType = fileType;
        this.size = size;
    }

    // getters only
    public String getFileName() {  return this.fileName; }
    public String getFileDownloadUri() { return this.fileDownloadUri; }
    public String getFileType() { return this.fileType; }
    public long getSize() { return this.size; }


}



