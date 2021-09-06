/*
 * This file is part of adventure, licensed under the MIT License.
 *
 * Copyright (c) 2017-2021 KyoriPowered
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
module net.kyori.adventure {
  requires static transitive org.jetbrains.annotations;
  requires net.kyori.examination.api;
  requires net.kyori.examination.string;
  requires net.kyori.adventure.key;

  exports net.kyori.adventure;
  exports net.kyori.adventure.audience;
  exports net.kyori.adventure.bossbar;
  exports net.kyori.adventure.identity;
  exports net.kyori.adventure.inventory;
  exports net.kyori.adventure.nbt.api;
  exports net.kyori.adventure.permission;
  exports net.kyori.adventure.pointer;
  exports net.kyori.adventure.sound;
  exports net.kyori.adventure.text;
  exports net.kyori.adventure.text.event;
  exports net.kyori.adventure.text.flattener;
  exports net.kyori.adventure.text.format;
  exports net.kyori.adventure.text.renderer;
  exports net.kyori.adventure.text.serializer;
  exports net.kyori.adventure.title;
  exports net.kyori.adventure.translation;
  exports net.kyori.adventure.util;
}
