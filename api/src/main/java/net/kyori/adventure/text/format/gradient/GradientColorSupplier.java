package net.kyori.adventure.text.format.gradient;

import net.kyori.adventure.text.format.TextColor;

@FunctionalInterface
public interface GradientColorSupplier {

  TextColor interpolate(float loc);

}
