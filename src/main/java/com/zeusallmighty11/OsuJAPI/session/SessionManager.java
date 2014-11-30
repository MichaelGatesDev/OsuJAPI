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


import com.zeusallmighty11.OsuJAPI.async.Callback;
import com.zeusallmighty11.OsuJAPI.tools.EnumAllWindowNames;


public class SessionManager
{
    // ============================================================================ \\

    private static SessionManager instance = new SessionManager();

    // ============================================================================ \\




    public SessionManager()
    {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> instance = null));
    }


    // ============================================================================ \\




    public void getCurrentSession(Callback callback)
    {
        new Thread(() -> {


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


            int startArg = 1;

            // if cutting edge build, there is extra thing
            if (rawTitle.contains("cutting"))
            {
                startArg = 2;
            }

            String[] ss = rawTitle.split(" ");
            String title = "";

            for (int i = startArg; i < ss.length; i++)
            {
                title += ss[i] + " ";
            }


            callback.onResponse(title);

        }).start();
    }


    // ============================================================================ \\




    public static SessionManager getInstance()
    {
        return instance;
    }




    // ============================================================================ \\
}
