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


public class UserNotFoundException extends Exception
{


    private static final String message = "Could not find a user by ID '{username}'! Double-check the spelling and try again?";
    private static final long serialVersionUID = 8295646472426218524L;




    /**
     * Thrown when a user is not found in the Osu! database.
     *
     * @param username Username
     */
    public UserNotFoundException(String username)
    {
        super(message.replace("{username}", username));
    }


}
