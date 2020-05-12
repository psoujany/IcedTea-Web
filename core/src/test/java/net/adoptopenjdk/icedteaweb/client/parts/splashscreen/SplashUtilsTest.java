/* SplashUtils.java
Copyright (C) 2012 Red Hat, Inc.

This file is part of IcedTea.

IcedTea is free software; you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation; either version 2, or (at your option)
any later version.

IcedTea is distributed in the hope that it will be useful, but
WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
General Public License for more details.

You should have received a copy of the GNU General Public License
along with IcedTea; see the file COPYING.  If not, write to the
Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
02110-1301 USA.

Linking this library statically or dynamically with other modules is
making a combined work based on this library.  Thus, the terms and
conditions of the GNU General Public License cover the whole
combination.

As a special exception, the copyright holders of this library give you
permission to link this library with independent modules to produce an
executable, regardless of the license terms of these independent
modules, and to copy and distribute the resulting executable under
terms of your choice, provided that you also meet, for each linked
independent module, the terms and conditions of the license of that
module.  An independent module is a module which is not derived from
or based on this library.  If you modify this library, you may extend
this exception to your version of the library, but you are not
obligated to do so.  If you do not wish to do so, delete this
exception statement from your version. */
package net.adoptopenjdk.icedteaweb.client.parts.splashscreen;

import net.adoptopenjdk.icedteaweb.client.parts.splashscreen.impls.DefaultSplashScreen2012;
import net.sourceforge.jnlp.runtime.JNLPRuntime;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.EnvironmentVariables;

import java.lang.reflect.Field;

import static net.adoptopenjdk.icedteaweb.IcedTeaWebConstants.ICEDTEA_WEB_SPLASH;
import static net.adoptopenjdk.icedteaweb.IcedTeaWebConstants.NO_SPLASH;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

public class SplashUtilsTest {
    
    private static final String DEFAULT = "";

    @Rule
    public EnvironmentVariables envVars = new EnvironmentVariables();

    @Before
    public void setUp() {
        envVars.clear(System.getenv().keySet().toArray(new String[0]));
        
        JNLPRuntime.setShowWebSplash(true);
    }

    @Test
    public void determineCallerTest() {
        SplashUtils.getSplashScreen();
    }

    @Test
    public void testGetSplashScreen1() {
        SplashPanel sw = SplashUtils.getSplashScreen();
        assertThat(sw, is(instanceOf(DefaultSplashScreen2012.class)));
    }

    @Test
    public void testGetSplashScreen2() {
        envVars.set(ICEDTEA_WEB_SPLASH, DEFAULT);

        SplashPanel sw = SplashUtils.getSplashScreen();
        assertThat(sw, is(instanceOf(DefaultSplashScreen2012.class)));
    }

    @Test
    public void testGetSplashScreen3() {
        envVars.set(ICEDTEA_WEB_SPLASH, NO_SPLASH);

        SplashPanel sw = SplashUtils.getSplashScreen();
        assertThat(sw, is(nullValue()));
    }

    @Test
    public void testGetSplashScreen4() {
        envVars.set(ICEDTEA_WEB_SPLASH, DEFAULT);

        SplashPanel sw = SplashUtils.getSplashScreen();
        assertThat(sw, is(instanceOf(DefaultSplashScreen2012.class)));
    }

    @Test
    public void testGetSplashScreen5() {
        envVars.set(ICEDTEA_WEB_SPLASH, NO_SPLASH);

        SplashPanel sw = SplashUtils.getSplashScreen();
        assertThat(sw, is(nullValue()));
    }

    @Test
    public void testGetSplashScreen6() {
        envVars.set(ICEDTEA_WEB_SPLASH, DEFAULT);

        SplashPanel sw = SplashUtils.getSplashScreen();
        assertThat(sw, is(instanceOf(DefaultSplashScreen2012.class)));
    }

    @Test
    public void testGetSplashScreen7() {
        envVars.set(ICEDTEA_WEB_SPLASH, "egtrutkyukl");

        SplashPanel sw = SplashUtils.getSplashScreen();
        assertThat(sw, is(instanceOf(DefaultSplashScreen2012.class)));
    }
    
    @Test
    public void testGetSplashScreen8() {
        JNLPRuntime.setShowWebSplash(false);

        SplashPanel sw = SplashUtils.getSplashScreen();
        assertThat(sw, is(nullValue()));
    }
}
