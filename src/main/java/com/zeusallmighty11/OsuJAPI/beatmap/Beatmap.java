/*
 * Copyright (C) 2014  ZeusAllMighty11
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.zeusallmighty11.OsuJAPI.beatmap;


import com.zeusallmighty11.OsuJAPI.async.Callback;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.Time;
import java.util.Date;


public class Beatmap
{
    // ======================================================================== \\


    ApprovalStatus status;
    Time approved;
    Date lastUpdate;
    String artist;
    int id;
    int setId;
    int bpm;
    String creator;
    double difficultyRating;
    int circleSize;
    double approachRate;
    int drain;
    int hitLength;
    String source;
    String title;
    int length;
    String version;
    GameMode mode;


    // ======================================================================== \\




    public Beatmap()
    {

    }




    /**
     * Parses a beatmap from an ID
     *
     * @return parsed beatmap
     */
    public static void fromID(final int id, final String key, Callback callback)
    {
        new Thread(() -> {
            String response = "";

            try
            {
                URL link = new URL("https://osu.ppy.sh/api/get_beatmaps?k=" + key + "&s=" + id);
                BufferedReader in = new BufferedReader(new InputStreamReader(link.openStream()));
                String inputLine;
                while ((inputLine = in.readLine()) != null)
                {
                    response = inputLine;
                }
                in.close();

                JSONArray array = new JSONArray(response);
                JSONObject json = array.getJSONObject(0);

                Beatmap beatmap = new Beatmap();

                beatmap.setStatus(ApprovalStatus.parseStatus(json.getInt("approved")));
                beatmap.setArtist(json.getString("artist"));
                beatmap.setId(json.getInt("beatmap_id"));
                beatmap.setSetId(json.getInt("beatmapset_id"));
                beatmap.setBPM(json.getInt("bpm"));
                beatmap.setCreator(json.getString("creator"));
                beatmap.setDifficultyRating(json.getDouble("difficultyrating"));
                beatmap.setCircleSize(json.getInt("diff_size"));
                beatmap.setApproachRate(Double.parseDouble(json.getString("diff_approach")));
                beatmap.setDrain(json.getInt("diff_drain"));
                beatmap.setHitLength(json.getInt("hit_length"));
                beatmap.setSource(json.getString("source"));
                beatmap.setTitle(json.getString("title"));
                beatmap.setLength(json.getInt("total_length"));
                beatmap.setVersion(json.getString("version"));
                beatmap.setMode(GameMode.parseMode(json.getInt("mode")));
                //TODO: date & time

                callback.onResponse(beatmap);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }).start();
    }




    /**
     * Parses a beatmap from an ID
     *
     * @return parsed beatmap
     */
    public static Beatmap parse(final JSONObject json)
    {
        Beatmap beatmap = new Beatmap();

        beatmap.setStatus(ApprovalStatus.parseStatus(json.getInt("approved")));
        beatmap.setArtist(json.getString("artist"));
        beatmap.setId(json.getInt("beatmap_id"));
        beatmap.setSetId(json.getInt("beatmapset_id"));
        beatmap.setBPM(json.getInt("bpm"));
        beatmap.setCreator(json.getString("creator"));
        beatmap.setDifficultyRating(json.getDouble("difficultyrating"));
        beatmap.setCircleSize(json.getInt("diff_size"));
        beatmap.setApproachRate(Double.parseDouble(json.getString("diff_approach")));
        beatmap.setDrain(json.getInt("diff_drain"));
        beatmap.setHitLength(json.getInt("hit_length"));
        beatmap.setSource(json.getString("source"));
        beatmap.setTitle(json.getString("title"));
        beatmap.setLength(json.getInt("total_length"));
        beatmap.setVersion(json.getString("version"));
        beatmap.setMode(GameMode.parseMode(json.getInt("mode")));
        //TODO: date & time

        return beatmap;
    }


    // ======================================================================== \\




    /**
     * Sets approval status
     *
     * @param status Status of approval
     */
    public void setStatus(ApprovalStatus status)
    {
        this.status = status;
    }




    /**
     * Sets date of approval
     *
     * @param approved java.sql.Date date
     */
    public void setApproved(Time approved)
    {
        this.approved = approved;
    }




    /**
     * Sets date of last update
     *
     * @param lastUpdate java.sql.Date date
     */
    public void setLastUpdate(Date lastUpdate)
    {
        this.lastUpdate = lastUpdate;
    }




    /**
     * Sets the track's artist
     *
     * @param artist Artist of the track
     */
    public void setArtist(String artist)
    {
        this.artist = artist;
    }




    /**
     * Sets the beatmap id of the track
     *
     * @param id Beatmap ID
     */
    public void setId(int id)
    {
        this.id = id;
    }




    /**
     * Sets the beatmap Set ID of the track
     *
     * @param setId Beatmap Set ID
     */
    public void setSetId(int setId)
    {
        this.setId = setId;
    }




    /**
     * Sets the beatmap BPM
     *
     * @param bpm BPM
     */
    public void setBPM(int bpm)
    {
        this.bpm = bpm;
    }




    /**
     * Sets the creator of the map
     *
     * @param creator Creator's name
     */
    public void setCreator(String creator)
    {
        this.creator = creator;
    }




    /**
     * Sets the difficulty ranking of the Beatmap (stars)
     *
     * @param difficultyRating Amount of stars
     */
    public void setDifficultyRating(double difficultyRating)
    {
        this.difficultyRating = difficultyRating;
    }




    /**
     * Sets the size of the circles in the beatmap
     *
     * @param circleSize Size of the circles
     */
    public void setCircleSize(int circleSize)
    {
        this.circleSize = circleSize;
    }




    /**
     * Sets the approach rate
     *
     * @param approachRate Approach rate
     */
    public void setApproachRate(double approachRate)
    {
        this.approachRate = approachRate;
    }




    /**
     * Sets the beatmap's HP drain amount
     *
     * @param drain Amount of HP drain
     */
    public void setDrain(int drain)
    {
        this.drain = drain;
    }




    /**
     * Sets the beatmap's hit length
     *
     * @param hitLength Hit length
     */
    public void setHitLength(int hitLength)
    {
        this.hitLength = hitLength;
    }




    /**
     * Sets the source of the Beatmap
     *
     * @param source Beatmap source
     */
    public void setSource(String source)
    {
        this.source = source;
    }




    /**
     * Sets the title of the beatmap
     *
     * @param title Title
     */
    public void setTitle(String title)
    {
        this.title = title;
    }




    /**
     * Sets the length of the beatmap (in seconds)
     *
     * @param length Length in sceonds
     */
    public void setLength(int length)
    {
        this.length = length;
    }




    /**
     * Sets the beatmap version
     *
     * @param version Version
     */
    public void setVersion(String version)
    {
        this.version = version;
    }




    /**
     * Sets the Osu gamemode of the beatmap
     *
     * @param mode Game mode
     */
    public void setMode(GameMode mode)
    {
        this.mode = mode;
    }



    // ======================================================================== \\




    /**
     * @return The approval status of the beatmap
     */
    public ApprovalStatus getStatus()
    {
        return status;
    }




    /**
     * @return The date the beatmap got approved for ranking
     */
    public Time getApproved()
    {
        return approved;
    }




    /**
     * @return The date of the last beatmap update
     */
    public Date getLastUpdate()
    {
        return lastUpdate;
    }




    /**
     * @return The artist of the beatmap
     */
    public String getArtist()
    {
        return artist;
    }




    /**
     * @return The ID of the beatmap
     */
    public int getId()
    {
        return id;
    }




    /**
     * @return The set ID of the beatmap
     */
    public int getSetId()
    {
        return setId;
    }




    /**
     * @return The BPM of the beatmap
     */
    public int getBPM()
    {
        return bpm;
    }




    /**
     * @return The creator of the beatmap
     */
    public String getCreator()
    {
        return creator;
    }




    /**
     * @return The difficulty (in stars) of the beatmap
     */
    public double getDifficultyRating()
    {
        return difficultyRating;
    }




    /**
     * @return The size of circles in the beatmap
     */
    public int getCircleSize()
    {
        return circleSize;
    }




    /**
     * @return The approach rate in the beatmap
     */
    public double getApproachRate()
    {
        return approachRate;
    }




    /**
     * @return The HP drain in the beatmap
     */
    public int getDrain()
    {
        return drain;
    }




    /**
     * @return The hit length in the beatmap
     */
    public int getHitLength()
    {
        return hitLength;
    }




    /**
     * @return The source of the beatmap
     */
    public String getSource()
    {
        return source;
    }




    /**
     * @return The title of the beatmap
     */
    public String getTitle()
    {
        return title;
    }




    /**
     * @return Length of the beatmap in seconds
     */
    public int getLength()
    {
        return length;
    }




    /**
     * @return Version of the beatmap
     */
    public String getVersion()
    {
        return version;
    }




    /**
     * @return Game mdoe of the beatmap
     */
    public GameMode getMode()
    {
        return mode;
    }




    // ======================================================================== \\




    @Override
    public String toString()
    {
        return "Beatmap{" +
                "status=" + status +
                ", approved=" + approved +
                ", lastUpdate=" + lastUpdate +
                ", artist='" + artist + '\'' +
                ", id=" + id +
                ", setId=" + setId +
                ", bpm=" + bpm +
                ", creator='" + creator + '\'' +
                ", difficultyRating=" + difficultyRating +
                ", circleSize=" + circleSize +
                ", approachRate=" + approachRate +
                ", drain=" + drain +
                ", hitLength=" + hitLength +
                ", source='" + source + '\'' +
                ", title='" + title + '\'' +
                ", length=" + length +
                ", version='" + version + '\'' +
                ", mode=" + mode +
                '}';
    }



    // ======================================================================== \\
}