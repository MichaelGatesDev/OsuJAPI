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

package com.animeniac.OsuJAPI.session;


import com.animeniac.OsuJAPI.async.Callback;
import com.animeniac.OsuJAPI.tools.EnumAllWindowNames;


public class SessionManager
{
    // ============================================================================ \\

    private static SessionManager instance = new SessionManager();

    // ============================================================================ \\




    public SessionManager()
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




    public void getCurrentSession(final Callback callback)
    {
        new Thread(new Runnable()
        {


            @Override
            public void run()
            {
                String rawTitle = "";



                for (String s : EnumAllWindowNames.getAllWindowNames())
                {
                    if (s.toLowerCase().startsWith("osu!"))
                    {
                        if (!s.contains("broadcaster") && !s.contains("firefox") && !s.contains("twitch"))
                        {
                            rawTitle = s;
                        }
                    }
                }

                // return the title


                int startArg = 3;

                // if cutting edge build, there is extra thing
                if (rawTitle.contains("cutting"))
                {
                    // not sure
                    startArg = 5;
                }

                String[] ss = rawTitle.split(" ");
                String title = "";

                for (int i = startArg; i < ss.length; i++)
                {
                    title += ss[i] + " ";
                }

                title = title.trim();

                callback.onResponse(title);
            }
        }).start();
    }


    // ============================================================================ \\




    public static SessionManager getInstance()
    {
        return instance;
    }




    // ============================================================================ \\
}
