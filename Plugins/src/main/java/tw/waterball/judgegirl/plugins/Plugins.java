/*
 * Copyright 2020 Johnny850807 (Waterball) 潘冠辰
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *       http://www.apache.org/licenses/LICENSE-2.0
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package tw.waterball.judgegirl.plugins;

import tw.waterball.judgegirl.plugins.api.JudgeGirlPlugin;
import tw.waterball.judgegirl.plugins.impl.match.AllMatchPolicyPlugin;
import tw.waterball.judgegirl.plugins.impl.match.RegexMatchPolicyPlugin;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * @author - johnny850807@gmail.com (Waterball)
 */
public class Plugins {
    private static List<JudgeGirlPlugin> DEFAULT_PLUGINS = asList(
            new AllMatchPolicyPlugin(), new RegexMatchPolicyPlugin());

    public static List<JudgeGirlPlugin> getDefaultPlugins() {
        return DEFAULT_PLUGINS;
    }
}
