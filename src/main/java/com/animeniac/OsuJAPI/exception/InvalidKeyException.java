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

package com.animeniac.OsuJAPI.exception;


public class InvalidKeyException extends Exception
{


    private static final String message = "The provided API key is invalid ({key}).";




    /**
     * Thrown when a key is not found in the Osu! database.
     *
     * @param key key
     */
    public InvalidKeyException(String key)
    {
        super(message.replace("{key}", key));
    }


}
