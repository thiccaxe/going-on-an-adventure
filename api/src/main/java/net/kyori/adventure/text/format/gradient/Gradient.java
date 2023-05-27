package net.kyori.adventure.text.format.gradient;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextColor;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public interface Gradient {


  static @NotNull LinearHSVGradient linearHSV() {
    return new LinearHSVGradient();
  }

  static @NotNull LinearRGBGradient linearRGB() {
    return new LinearRGBGradient();
  }

  @NotNull TextColor interpolate(float pos, TextColor startColor, TextColor endColor);

  static Component gradient(String text, GradientColorSupplier colorSupplier) {
    TextComponent.@NotNull Builder builder = Component.text();
    for (int index = 0; index < text.length(); index++) {
      builder.append(Component.text(
        text.substring(index, index + 1),
        colorSupplier.interpolate(
          ((float) index) / text.length()
        )
      ));
    }
    return builder.build();
  }

  static float lerp(float pos, float start, float end) { //todo extract logic w/
    final float clamped = Math.max(0f, Math.min(1f, pos));
    return start + (end-start)*clamped;
  }

  default GradientColorSupplier colors(TextColor startColor, TextColor endColor) {
    return colors(startColor, Collections.emptyList(), endColor);
  }

  default GradientColorSupplier colors(TextColor startColor, List<GradientStop> stops, TextColor endColor) {
    final List<GradientStop> sortedStops = new ArrayList<>(stops);
    Collections.sort(sortedStops);
    return (pos) -> {
      final float clamped = Math.max(0f, Math.min(1f, pos));
      // We can simply return the end point color if that is what is requested.
      if (clamped == 0f) return startColor;
      if (clamped == 1f) return endColor;

      GradientStop gradientStart = GradientStop.gradientStop(startColor, 0f);
      GradientStop gradientEnd = GradientStop.gradientStop(endColor, 1f);
      for (final GradientStop stop : sortedStops) {
        // Another shortcut to return quickly
        if (clamped == stop.position()) return stop.color();
        if (clamped < stop.position()) {
          gradientEnd = stop;
          break;
        }
        gradientStart = stop;
      }

      final float scaledPosition = (clamped - gradientStart.position()) / (gradientEnd.position() - gradientStart.position());

      return interpolate(scaledPosition, gradientStart.color(), gradientEnd.color());
    };
  }



}
