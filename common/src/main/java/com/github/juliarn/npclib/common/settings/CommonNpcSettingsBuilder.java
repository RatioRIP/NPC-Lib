/*
 * This file is part of npc-lib, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2022 Julian M., Pasqual K. and contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.github.juliarn.npclib.common.settings;

import com.github.juliarn.npclib.api.settings.NpcProfileResolver;
import com.github.juliarn.npclib.api.settings.NpcSettings;
import com.github.juliarn.npclib.api.settings.NpcTrackingRule;
import com.github.juliarn.npclib.common.flag.CommonNpcFlaggedBuilder;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

public class CommonNpcSettingsBuilder<P>
  extends CommonNpcFlaggedBuilder<NpcSettings.Builder<P>>
  implements NpcSettings.Builder<P> {

  protected NpcTrackingRule<P> trackingRule = NpcTrackingRule.allPlayers();
  protected NpcProfileResolver<P> profileResolver = NpcProfileResolver.ofSpawnedNpc();

  @Override
  public NpcSettings.@NotNull Builder<P> trackingRule(@NotNull NpcTrackingRule<P> trackingRule) {
    this.trackingRule = Objects.requireNonNull(trackingRule, "trackingRule");
    return this;
  }

  @Override
  public NpcSettings.@NotNull Builder<P> profileResolver(@NotNull NpcProfileResolver<P> profileResolver) {
    this.profileResolver = Objects.requireNonNull(profileResolver, "profileResolver");
    return this;
  }

  @Override
  public @NotNull NpcSettings<P> build() {
    return new CommonNpcSettings<>(this.flags, this.trackingRule, this.profileResolver);
  }
}