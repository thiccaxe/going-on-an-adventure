package net.kyori.adventure.gradient;

import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.util.RGBLike;

import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

public final class LinearRGBGradient implements GradientGenerator<RGBLike> {
  public static final Function<RGBLike, RGBLike> RGB_SUPPLIER = TextColor::color;
  @Override
  public GradientColorSupplier<RGBLike> generateColors(RGBLike start, List<GradientStop<RGBLike>> gradientStops, RGBLike end, double phase) {
    return null;
  }
  
}
