

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


import com.michaelgatesdev.OsuJAPI.async.Callback;
import com.michaelgatesdev.OsuJAPI.exception.BeatmapNotFoundException;
import com.michaelgatesdev.OsuJAPI.exception.InvalidKeyException;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;


public class BeatmapManager
{
    // ============================================================================ \\

    private static BeatmapManager instance = new BeatmapManager();

    private static final String URL_BEATMAP = "http://osu.ppy.sh/api/get_beatmaps";



    // ============================================================================ \\




    public BeatmapManager()
    {
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable()
        {


            @Override
            public void run()
            {
                instance = null;
            }
        }));
    }


    // ============================================================================ \\




    /**
     * Grabs a user by their username.
     *
     * @param id       Beatmap Set ID
     * @param key      Osu! API Key
     * @param callback Implementation of the callback interface
     *
     * @throws BeatmapNotFoundException If a beatmap is not found
     * @throws InvalidKeyException      If an API Key is not valid
     */
    public void getBeatmap(final int id, final String key, final Callback callback) throws BeatmapNotFoundException, InvalidKeyException
    {
        new Thread(new Runnable()
        {


            @Override
            public void run()
            {
                try
                {
                    URL url = new URL(URL_BEATMAP + "?k=" + key + "&s=" + id);


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
                    if (response.contains("[]"))
                    {
                        // throw user not found exception
                        throw new BeatmapNotFoundException(id);
                    }

                    // transform result into object json
                    JSONArray array = new JSONArray(response);
                    JSONObject json = array.getJSONObject(0);

                    // parse the beatmap
                    Beatmap beatmap = Beatmap.parse(json);

                    // respond with the user
                    callback.onResponse(beatmap);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    // ============================================================================ \\




    public static BeatmapManager getInstance()
    {
        return instance;
    }



    // ============================================================================ \\
}
