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
package net.kyori.adventure.text;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;
import net.kyori.adventure.text.format.Style;
import net.kyori.examination.ExaminableProperty;
import net.kyori.examination.string.StringExaminer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static java.util.Objects.requireNonNull;

final record KeybindComponentImpl(
  @NotNull List<Component> children,
  @NotNull Style style,
  @NotNull String keybind
) implements KeybindComponent {
  KeybindComponentImpl(final @NotNull List<Component> children, final @NotNull Style style, final @NotNull String keybind) {
    this.children = List.copyOf(children);
    this.style = style;
    this.keybind = keybind;
  }

  @Override
  public @NotNull KeybindComponent keybind(final @NotNull String keybind) {
    if (Objects.equals(this.keybind, keybind)) return this;
    return new KeybindComponentImpl(this.children, this.style, requireNonNull(keybind, "keybind"));
  }

  @Override
  public @NotNull KeybindComponent children(final @NotNull List<? extends ComponentLike> children) {
    return new KeybindComponentImpl(ComponentLike.asComponents(children, NOT_EMPTY), this.style, this.keybind);
  }

  @Override
  public @NotNull KeybindComponent style(final @NotNull Style style) {
    return new KeybindComponentImpl(this.children, style, this.keybind);
  }

  @Override
  public @NotNull Stream<? extends ExaminableProperty> examinableProperties() {
    return Stream.concat(
      Stream.of(
        ExaminableProperty.of("keybind", this.keybind)
      ),
      KeybindComponent.super.examinableProperties()
    );
  }

  @Override
  public String toString() {
    return this.examine(StringExaminer.simpleEscaping());
  }

  @Override
  public @NotNull Builder toBuilder() {
    return new BuilderImpl(this);
  }

  static final class BuilderImpl extends AbstractComponentBuilder<KeybindComponent, Builder> implements KeybindComponent.Builder {
    private @Nullable String keybind;

    BuilderImpl() {
    }

    BuilderImpl(final @NotNull KeybindComponent component) {
      super(component);
      this.keybind = component.keybind();
    }

    @Override
    public @NotNull Builder keybind(final @NotNull String keybind) {
      this.keybind = keybind;
      return this;
    }

    @Override
    public @NotNull KeybindComponent build() {
      if (this.keybind == null) throw new IllegalStateException("keybind must be set");
      return new KeybindComponentImpl(this.children, this.buildStyle(), this.keybind);
    }
  }
}
