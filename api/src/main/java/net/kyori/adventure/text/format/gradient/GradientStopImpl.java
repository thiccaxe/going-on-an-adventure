package net.kyori.adventure.text.format.gradient;

import net.kyori.adventure.text.format.TextColor;
import org.jetbrains.annotations.NotNull;

public class GradientStopImpl implements GradientStop {

  private final @NotNull TextColor color;
  private final @NotNull Float position;

  GradientStopImpl(final @NotNull TextColor color, final @NotNull Float position) {
    this.color = color;
    this.position = position;
  }

  @Override
  public @NotNull TextColor color() {
    return this.color;
  }

  @Override
  public @NotNull Float- position() {
    return this.position;
  }
}
