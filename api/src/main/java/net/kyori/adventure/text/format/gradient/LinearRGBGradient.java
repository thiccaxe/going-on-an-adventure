package net.kyori.adventure.text.format.gradient;

import net.kyori.adventure.text.format.TextColor;
import org.jetbrains.annotations.NotNull;

public final class LinearRGBGradient implements Gradient {


  LinearRGBGradient() {

  }
  @Override
  public @NotNull TextColor interpolate(float pos, TextColor startColor, TextColor endColor) {
    return TextColor.lerp(pos, startColor, endColor);
  }
}
