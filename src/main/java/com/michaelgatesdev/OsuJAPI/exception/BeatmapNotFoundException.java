/*
 * Copyright (C) Michael Gates (MichaelGatesDev) 2015
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

package com.michaelgatesdev.OsuJAPI.exception;


public class BeatmapNotFoundException extends Exception
{


    private static final String message = "Could not find a beatmap by ID '{beatmap}'! Double-check the id and try again?";
    private static final long serialVersionUID = 7429776496262285437L;




    /**
     * Thrown when a user is not found in the Osu! database.
     *
     * @param id ID
     */
    public BeatmapNotFoundException(int id)
    {
        super(message.replace("{beatmap}", id + ""));
    }


}
