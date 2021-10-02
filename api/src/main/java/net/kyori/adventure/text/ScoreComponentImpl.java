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

final record ScoreComponentImpl(
  @NotNull List<Component> children,
  @NotNull Style style,
  @NotNull String name,
  @NotNull String objective,
  @Deprecated @Nullable String value
) implements ScoreComponent {
  @Override
  public @NotNull ScoreComponent name(final @NotNull String name) {
    if (Objects.equals(this.name, name)) return this;
    return new ScoreComponentImpl(this.children, this.style, requireNonNull(name, "name"), this.objective, this.value);
  }

  @Override
  public @NotNull ScoreComponent objective(final @NotNull String objective) {
    if (Objects.equals(this.objective, objective)) return this;
    return new ScoreComponentImpl(this.children, this.style, this.name, requireNonNull(objective, "objective"), this.value);
  }

  @Override
  @Deprecated
  public @NotNull ScoreComponent value(final @Nullable String value) {
    if (Objects.equals(this.value, value)) return this;
    return new ScoreComponentImpl(this.children, this.style, this.name, this.objective, value);
  }

  @Override
  public @NotNull ScoreComponent children(final @NotNull List<? extends ComponentLike> children) {
    return new ScoreComponentImpl(ComponentLike.asComponents(children, NOT_EMPTY), this.style, this.name, this.objective, this.value);
  }

  @Override
  public @NotNull ScoreComponent style(final @NotNull Style style) {
    return new ScoreComponentImpl(this.children, style, this.name, this.objective, this.value);
  }

  @Override
  public @NotNull Stream<? extends ExaminableProperty> examinableProperties() {
    return Stream.concat(
      Stream.of(
        ExaminableProperty.of("name", this.name),
        ExaminableProperty.of("objective", this.objective),
        ExaminableProperty.of("value", this.value)
      ),
      ScoreComponent.super.examinableProperties()
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

  static final class BuilderImpl extends AbstractComponentBuilder<ScoreComponent, Builder> implements ScoreComponent.Builder {
    private @Nullable String name;
    private @Nullable String objective;
    private @Nullable String value;

    BuilderImpl() {
    }

    @SuppressWarnings("deprecation")
    BuilderImpl(final @NotNull ScoreComponent component) {
      super(component);
      this.name = component.name();
      this.objective = component.objective();
      this.value = component.value();
    }

    @Override
    public @NotNull Builder name(final @NotNull String name) {
      this.name = name;
      return this;
    }

    @Override
    public @NotNull Builder objective(final @NotNull String objective) {
      this.objective = objective;
      return this;
    }

    @Override
    @Deprecated
    public @NotNull Builder value(final @Nullable String value) {
      this.value = value;
      return this;
    }

    @Override
    public @NotNull ScoreComponent build() {
      if (this.name == null) throw new IllegalStateException("name must be set");
      if (this.objective == null) throw new IllegalStateException("objective must be set");
      return new ScoreComponentImpl(this.children, this.buildStyle(), this.name, this.objective, this.value);
    }
  }
}
