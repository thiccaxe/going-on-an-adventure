package net.kyori.adventure.gradient;

import net.kyori.adventure.util.RGBLike;

@FunctionalInterface
public interface GradientColorSupplier<Space> {

  Space interpolate(double loc);

}
