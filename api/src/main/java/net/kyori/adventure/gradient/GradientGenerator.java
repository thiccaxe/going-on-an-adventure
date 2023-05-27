package net.kyori.adventure.gradient;

import net.kyori.adventure.util.RGBLike;

import java.util.Iterator;
import java.util.List;

public interface GradientGenerator<Space> {

  GradientColorSupplier<Space> generateColors(Space start, List<GradientStop<Space>> stops, Space end, double phase);
}
