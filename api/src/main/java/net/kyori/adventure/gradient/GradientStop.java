package net.kyori.adventure.gradient;

import net.kyori.adventure.util.RGBLike;
import org.jetbrains.annotations.NotNull;

/**
 * Represents a stop (a color target) along a gradient.
 */
public interface GradientStop<Space> {

  @NotNull Space color();

  /**
   * Position from 0.0 to 1.0, inclusive, which represents where in the gradient the stop is.
   * @return the position
   */
  @NotNull Double position();
  
}
