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


import com.zeusallmighty11.OsuJAPI.async.Callback;
import com.zeusallmighty11.OsuJAPI.exception.InvalidKeyException;
import com.zeusallmighty11.OsuJAPI.exception.UserNotFoundException;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;


public class UserManager
{
    // ============================================================================ \\

    private static UserManager instance = new UserManager();

    private static final String URL_USER = "https://osu.ppy.sh/api/get_user";



    // ============================================================================ \\




    public UserManager()
    {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> instance = null));
    }


    // ============================================================================ \\




    /**
     * Grabs a user by their username.
     *
     * @param username Osu! username
     * @param key      Osu! API Key
     * @param callback Implementation of the callback interface
     * @throws UserNotFoundException If a user is not found
     * @throws InvalidKeyException   If an API Key is not valid
     */
    public void getUser(final String username, final String key, Callback callback) throws UserNotFoundException, InvalidKeyException
    {
        try
        {
            URL url = new URL(URL_USER + "?k=" + key + "&u=" + username);


            String response = "Please provide a valid API key.";
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null)
            {
                response = inputLine;
            }


            // if the key was invalid
            if (response.contains("Please provide a valid API key."))
            {
                // throw invalid key exception
                throw new InvalidKeyException(key);
            }



            // if the user doesn't exist
            if (response.length() < 10)
            {
                // throw user not found exception
                throw new UserNotFoundException(username);
            }



            // transform result into object json
            JSONArray array = new JSONArray(response);
            JSONObject json = array.getJSONObject(0);




            // parse the user
            User user = User.parseUser(json);


            // respond with the user
            callback.onResponse(user);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    // ============================================================================ \\




    public static UserManager getInstance()
    {
        return instance;
    }



    // ============================================================================ \\
}
