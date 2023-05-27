package net.kyori.adventure.text.format.gradient;

import net.kyori.adventure.text.format.TextColor;
import org.jetbrains.annotations.NotNull;

/**
 * Represents a stop (a color target) along a gradient.
 */
public interface GradientStop extends Comparable<GradientStop> {

  static GradientStop gradientStop(final @NotNull TextColor color, final @NotNull Float position) {
    return new GradientStopImpl(color, position);
  }


  @NotNull TextColor color();

  /**
   * Position from 0.0 to 1.0, inclusive, which represents where in the gradient the stop is.
   * @return the position
   */
  @NotNull Float position();

  @Override
  default int compareTo(@NotNull GradientStop o) {
    return position().compareTo(o.position());
  }
}
