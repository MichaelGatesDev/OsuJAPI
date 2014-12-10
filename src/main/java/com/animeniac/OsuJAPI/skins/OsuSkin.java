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

package com.animeniac.OsuJAPI.skins;


import com.animeniac.OsuJAPI.async.Callback;

import java.io.File;


public class OsuSkin
{
    // ============================================================================ \\


    String name;
    String downloadURL;
    boolean privateSkin;
    boolean customSkin;

    // ============================================================================ \\




    public OsuSkin(String name)
    {
        this.name = name;
    }


    // ============================================================================ \\




    /**
     * Not implemented
     *
     * @return nothing yet
     */
    public static OsuSkin getCurrentSkin()
    {
        return null;
    }




    public static void listAllSkins(final File skinsDir, final Callback callback)
    {
        new Thread(new Runnable()
        {


            @Override
            public void run()
            {
                StringBuilder sb = new StringBuilder();

                for (File f : skinsDir.listFiles())
                {
                    if (f.isDirectory())
                    {
                        sb.append(f.getName()).append(" ");
                    }
                }

                callback.onResponse(sb.toString());
            }
        }).start();
    }


    // ============================================================================ \\




    public String getName()
    {
        return name;
    }




    public String getDownloadURL()
    {
        return downloadURL;
    }




    public boolean isPrivateSkin()
    {
        return privateSkin;
    }




    public boolean isCustomSkin()
    {
        return customSkin;
    }

    // ============================================================================ \\
}
