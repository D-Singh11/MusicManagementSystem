/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nextgate.assesment.datatypes;

/**
 * A basic data structure representing a song.
 *
 * TODO: Add fields based on the given data
 *
 * @author nextgate.employee
 */
public class SingerCode {

    private String name;
    private int singerId;

    /**
     * Primary constructor.
     *
     * @param title the song title
     */
    public SingerCode(String name) {
        this.name = name;
    }

    /**
     * Secondary constructor.
     *
     * @param title the song title
     * @param rating the rating of the song
     */
    public SingerCode(String name, int singerId) {
        this(name);
        this.singerId = singerId;
    }

    /**
     * @return the song title
     */
    public String getName() {
        return name;
    }

    /**
     * @param title the song title
     * @return this
     */
    public SingerCode setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * @return the song rating
     */
    public int getSingerId() {
        return singerId;
    }

    /**
     * @param rating the song rating
     * @return this
     */
    public SingerCode setSingerId(int singerId) {
        this.singerId = singerId;
        return this;
    }

}
