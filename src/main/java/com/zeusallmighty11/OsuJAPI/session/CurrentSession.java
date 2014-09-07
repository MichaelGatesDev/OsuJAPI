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

package com.zeusallmighty11.OsuJAPI.session;


public class CurrentSession
{
    // ============================================================================ \\

    String currentSong;


    // ============================================================================ \\




    public CurrentSession(String currentSong)
    {
        this.currentSong = currentSong;
    }


    // ============================================================================ \\




    /**
     * Sets the song that is currently playing
     *
     * @param currentSong song name
     */
    public void setCurrentSong(String currentSong)
    {
        this.currentSong = currentSong;
    }




    /**
     * @return The song that is currently playing
     */
    public String getCurrentSong()
    {
        return currentSong;
    }



    // ============================================================================ \\
}
