package net.kyori.adventure.text.format.gradient;

import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.util.HSVLike;
import org.jetbrains.annotations.NotNull;

public class LinearHSVGradient implements Gradient {

  LinearHSVGradient() {


  }

  private float clampHue(float hue) {
    return (1 + (hue % 1)) % 1;
  }

  @Override
  public @NotNull TextColor interpolate(float pos, TextColor startColor, TextColor endColor) {
    final HSVLike hsvStart = startColor.asHSV();
    final HSVLike hsvEnd = endColor.asHSV();

    final float saturation = Gradient.lerp(pos, hsvStart.s(), hsvEnd.s());
    final float value = Gradient.lerp(pos, hsvStart.v(), hsvEnd.v());

    float angleStart = clampHue(hsvStart.h());
    float angleEnd = clampHue(hsvEnd.h());
    final float delta = angleEnd - angleStart;

    if (delta < 0) {
      angleEnd += 1.0f;
    }
    final float hue = clampHue(Gradient.lerp(pos, angleStart, angleEnd));

    return TextColor.color(HSVLike.hsvLike(
      hue, saturation, value
    ));

  }
}
