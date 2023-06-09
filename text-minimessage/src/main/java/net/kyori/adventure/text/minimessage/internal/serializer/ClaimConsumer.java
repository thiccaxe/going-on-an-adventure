/*
 * This file is part of adventure, licensed under the MIT License.
 *
 * Copyright (c) 2017-2023 KyoriPowered
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package net.kyori.adventure.text.minimessage.internal.serializer;

import org.jetbrains.annotations.NotNull;

/**
 * A consumer of serialization claims.
 *
 * @since 4.10.0
 */
public interface ClaimConsumer {
  /**
   * Submit a style claim for the active component.
   *
   * <p>Style claims are additive, but any single style element can only be claimed once.</p>
   *
   * @param claimKey an identifier for the style element being claimed
   * @param styleClaim the claim of a style
   * @since 4.10.0
   */
  void style(final @NotNull String claimKey, final @NotNull Emitable styleClaim);

  /**
   * Submit a component claim for the active component.
   *
   * <p>Only one component claim can be in effect. We use the first component claim.</p>
   *
   * @param componentClaim the claim of a component
   * @return whether the claim was successful
   * @since 4.10.0
   */
  boolean component(final @NotNull Emitable componentClaim);

  /**
   * Get whether a style element has been claimed yet.
   *
   * @param claimId the id for this style elemnt being tested
   * @return whether style is claimed
   * @since 4.10.0
   */
  boolean styleClaimed(final @NotNull String claimId);

  /**
   * Get whether a component has been claimed yet.
   *
   * @return whether a component has been claimed yet
   * @since 4.10.0
   */
  boolean componentClaimed();
}
