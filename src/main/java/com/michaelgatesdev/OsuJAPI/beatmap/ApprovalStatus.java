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

package com.michaelgatesdev.OsuJAPI.beatmap;


public enum ApprovalStatus
{
    /**
     * Qualified for ranking
     */
    QUALIFIED,

    /**
     * Approved for ranking
     */
    APPROVED,


    /**
     * Ranked
     */
    RANKED,

    /**
     * Pending approval
     */
    PENDING,

    /**
     * Not finished
     */
    WIP,

    /**
     * Dead (no longer played)
     */
    GRAVEYARD;




    public static ApprovalStatus parseStatus(int status)
    {
        switch (status)
        {
            case 3:
                return QUALIFIED;
            case 2:
                return RANKED;
            case 1:
                return RANKED;
            case 0:
                return PENDING;
            case -1:
                return WIP;
            case -2:
                return GRAVEYARD;
        }
        return null;
    }
}
