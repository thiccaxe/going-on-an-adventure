package net.kyori.adventure.gradient;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.util.RGBLike;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public interface Gradient<Space, RGBSupplier extends Function<Space, RGBLike>> {

  static <Space, RGBSupplier extends Function<Space, RGBLike>> Gradient<Space, RGBSupplier> colorSpace(
    GradientGenerator<Space> gradientGenerator
  ) {
    return null;
  }

  static <Space, RGBSupplier extends Function<Space, RGBLike>> Component gradient(
    String text,
    GradientColorSupplier<Space> colorSupplier,
    RGBSupplier rgbSupplier
  ) {
    TextComponent.@NotNull Builder builder = Component.text();
    for (int index = 0; index < text.length(); index++) {
      builder.append(Component.text(
        text.substring(index, index + 1),
        TextColor.color(rgbSupplier.apply(colorSupplier.interpolate(
          ((double) index) / text.length()
        )))
      ));
    }
    return builder.build();
  }

  default GradientColorSupplier<Space> colors(Space start, Space end) {
    return colors(start, end, 0d);
  }

  default GradientColorSupplier<Space> colors(Space start, Space end, double phase) {
    return colors(start, Collections.emptyList(), end, phase);
  }

  default GradientColorSupplier<Space> colors(Space start, List<GradientStop<Space>> stops, Space end) {
    return colors(start, stops, end, 0d);
  }

  GradientColorSupplier<Space> colors(Space start, List<GradientStop<Space>> stops, Space end, double phase);

}
