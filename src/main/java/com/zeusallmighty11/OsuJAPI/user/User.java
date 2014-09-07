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

package com.zeusallmighty11.OsuJAPI.user;


import org.json.JSONObject;


public class User
{
    // ============================================================================ \\


    int userID;
    String username;
    int count300;
    int count100;
    int count50;
    int playCount;
    int rankedScore;
    int totalScore;
    int ppRank;
    double level;
    double ppRaw;
    double accuracy;
    int countRankSS;
    int countRankS;
    int countRankA;
    String country;

    // ============================================================================ \\




    public User()
    {
    }


    // ============================================================================ \\




    /**
     * Parses a User from a JSONObject
     *
     * @param json JSONObject to parse from
     * @return A parsed user (or null if none)
     */
    public static User parseUser(JSONObject json)
    {
        User user = new User();
        user.setUserID(json.getInt("user_id"));
        user.setUsername(json.getString("username"));
        user.setCount300(json.getInt("count300"));
        user.setCount100(json.getInt("count100"));
        user.setCount50(json.getInt("count50"));
        user.setPlayCount(json.getInt("playcount"));
        user.setRankedScore(json.getInt("ranked_score"));
        user.setTotalScore(json.getInt("total_score"));
        user.setPpRank(json.getInt("pp_rank"));
        user.setLevel(json.getDouble("level"));
        user.setPpRaw(json.getDouble("pp_raw"));
        user.setAccuracy(json.getDouble("accuracy"));
        user.setCountRankSS(json.getInt("count_rank_ss"));
        user.setCountRankS(json.getInt("count_rank_s"));
        user.setCountRankA(json.getInt("count_rank_a"));
        user.setCountry(json.getString("country"));
        return user;
    }

    // ============================================================================ \\




    public void setUserID(int userID)
    {
        this.userID = userID;
    }




    public void setUsername(String username)
    {
        this.username = username;
    }




    public void setCount300(int count300)
    {
        this.count300 = count300;
    }




    public void setCount100(int count100)
    {
        this.count100 = count100;
    }




    public void setCount50(int count50)
    {
        this.count50 = count50;
    }




    public void setPlayCount(int playCount)
    {
        this.playCount = playCount;
    }




    public void setRankedScore(int rankedScore)
    {
        this.rankedScore = rankedScore;
    }




    public void setTotalScore(int totalScore)
    {
        this.totalScore = totalScore;
    }




    public void setPpRank(int ppRank)
    {
        this.ppRank = ppRank;
    }




    public void setLevel(double level)
    {
        this.level = level;
    }




    public void setPpRaw(double ppRaw)
    {
        this.ppRaw = ppRaw;
    }




    public void setAccuracy(double accuracy)
    {
        this.accuracy = accuracy;
    }




    public void setCountRankSS(int countRankSS)
    {
        this.countRankSS = countRankSS;
    }




    public void setCountRankS(int countRankS)
    {
        this.countRankS = countRankS;
    }




    public void setCountRankA(int countRankA)
    {
        this.countRankA = countRankA;
    }




    public void setCountry(String country)
    {
        this.country = country;
    }



    // ============================================================================ \\




    public int getUserID()
    {
        return userID;
    }




    public String getUsername()
    {
        return username;
    }




    public int getCount300()
    {
        return count300;
    }




    public int getCount100()
    {
        return count100;
    }




    public int getCount50()
    {
        return count50;
    }




    public int getPlayCount()
    {
        return playCount;
    }




    public int getRankedScore()
    {
        return rankedScore;
    }




    public int getTotalScore()
    {
        return totalScore;
    }




    public int getPpRank()
    {
        return ppRank;
    }




    public double getLevel()
    {
        return level;
    }




    public double getPpRaw()
    {
        return ppRaw;
    }




    public double getAccuracy()
    {
        return accuracy;
    }




    public int getCountRankSS()
    {
        return countRankSS;
    }




    public int getCountRankS()
    {
        return countRankS;
    }




    public int getCountRankA()
    {
        return countRankA;
    }




    public String getCountry()
    {
        return country;
    }




    // ============================================================================ \\
}
