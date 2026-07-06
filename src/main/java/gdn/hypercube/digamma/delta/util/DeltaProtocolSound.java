package gdn.hypercube.digamma.delta.util;

import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

public enum DeltaProtocolSound {
    SPARKLE("")
    ;

    final String name;

    DeltaProtocolSound(String name) {
        this.name = name;
    }

    @Nullable
    public Identifier get() {
        return this.name.isEmpty() ? null : Identifier.of("digamma", this.name);
    }
}
