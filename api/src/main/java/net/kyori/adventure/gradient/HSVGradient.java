package net.kyori.adventure.gradient;

import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.util.HSVLike;
import net.kyori.adventure.util.RGBLike;

import java.util.List;
import java.util.function.Function;

public class HSVGradient implements GradientGenerator<HSVLike> {
  public static final Function<HSVLike, RGBLike> RGB_GENERATOR = TextColor::color;
  @Override
  public GradientColorSupplier<HSVLike> generateColors(HSVLike start, List<GradientStop<HSVLike>> gradientStops, HSVLike end, double phase) {
    return null;
  }
}
