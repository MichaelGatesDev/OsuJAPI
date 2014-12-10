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

package com.animeniac.OsuJAPI.beatmap;


public enum GameMode
{
    /**
     * Osu! mode
     */
    OSU,

    /**
     * Taiko mode
     */
    TAIKO,

    /**
     * Osu! Mania mode
     */
    MANIA,

    /**
     * Catch the Food mode
     */
    FOOD;




    public static GameMode parseMode(int mode)
    {
        switch (mode)
        {
            case 0:
                return OSU;
            case 1:
                return TAIKO;
            case 2:
                return MANIA;
            case 3:
                return FOOD;
            default:
                return OSU;
        }
    }

}