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

package com.michaelgatesdev.OsuJAPI.tools;


import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.win32.StdCallLibrary;

import java.util.ArrayList;
import java.util.List;


public class EnumAllWindowNames
{


    interface User32 extends StdCallLibrary
    {


        User32 INSTANCE = (User32) Native.loadLibrary("user32", User32.class);




        interface WNDENUMPROC extends StdCallCallback
        {


            boolean callback(Pointer hWnd, Pointer arg);
        }

        boolean EnumWindows(WNDENUMPROC lpEnumFunc, Pointer userData);

        int GetWindowTextA(Pointer hWnd, byte[] lpString, int nMaxCount);

        Pointer GetWindow(Pointer hWnd, int uCmd);
    }




    public static List<String> getAllWindowNames()
    {
        final List<String> windowNames = new ArrayList<>();
        final User32 user32 = User32.INSTANCE;

        user32.EnumWindows(new User32.WNDENUMPROC()
        {


            @Override
            public boolean callback(Pointer hWnd, Pointer arg)
            {
                byte[] windowText = new byte[512];
                user32.GetWindowTextA(hWnd, windowText, 512);
                String wText = Native.toString(windowText).trim();
                if (!wText.isEmpty())
                {
                    windowNames.add(wText);
                }
                return true;
            }
        }, null);

        return windowNames;
    }




    public static void main(String[] args)
    {
        List<String> winNameList = getAllWindowNames();
        for (String winName : winNameList)
        {
            System.out.println(winName);
        }
    }
}
