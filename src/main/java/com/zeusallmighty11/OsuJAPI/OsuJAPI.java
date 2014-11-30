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

package com.zeusallmighty11.OsuJAPI;


import com.zeusallmighty11.OsuJAPI.session.CurrentSession;
import com.zeusallmighty11.OsuJAPI.session.SessionManager;


public class OsuJAPI
{
    // ============================================================================ \\

    private static final String VERSION = "${project.version}";
    private static OsuJAPI instance;

    private CurrentSession currentSession;


    private String apiKey;

    // ============================================================================ \\




    public OsuJAPI(String key)
    {
        instance = this;

        this.apiKey = key;
    }




    // STRICTLY FOR DEBUGGING
    public static void main(String[] args)
    {
        SessionManager.getInstance().getCurrentSession(o -> {
            System.out.println(o);
        });
    }



    // ============================================================================ \\




    public void setApiKey(String apiKey)
    {
        this.apiKey = apiKey;
    }




    public void setCurrentSession(CurrentSession currentSession)
    {
        this.currentSession = currentSession;
    }




    // ============================================================================ \\




    /**
     * @return Current user session
     */
    public CurrentSession getSession()
    {
        return currentSession;
    }




    /**
     * @return The current version of the API
     */
    public static String getVersion()
    {
        return VERSION;
    }




    /**
     * @return A CurrentSession object of the user's current session (if any)
     */
    public CurrentSession getCurrentSession()
    {
        return currentSession;
    }




    /**
     * @return The configured API Key used to access the Osu! API
     */
    public String getApiKey()
    {
        return apiKey;
    }




    /**
     * @return Singleton instance of the Osu! Java API
     */
    public static OsuJAPI getInstance()
    {
        return instance;
    }


    // ============================================================================ \\
}
