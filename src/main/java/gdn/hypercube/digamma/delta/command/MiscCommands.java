package gdn.hypercube.digamma.delta.command;

import gdn.hypercube.digamma.delta.core.DeltaProtocolAudioEngine;
import gdn.hypercube.digamma.delta.core.DeltaProtocolBootSequence;
import gdn.hypercube.digamma.delta.core.DeltaProtocolMainHandler;
import gdn.hypercube.digamma.delta.util.DeltaProtocolSound;
import gdn.hypercube.epsilon.core.util.Argument;
import gdn.hypercube.epsilon.core.util.EngineCommand;

public class MiscCommands {
    EngineCommand VarFill = new EngineCommand(EngineCommand.Type.PLAFORM_SPECIFIC, 0x03, (engine, argv) -> {
        int index = (int) argv[0].value;
        int length = (int) argv[1].value;
        System.out.println("Length target: " + length);
        String target = DeltaProtocolBootSequence.VARIABLES.get(index).get();
        if (target.length() < length) length = target.length();
        target.getChars(0, length, engine.script, engine.ip+1);
    }, new Argument(Argument.Type.SHORT), new Argument(Argument.Type.BYTE));

    EngineCommand PlaySound = new EngineCommand(EngineCommand.Type.PLAFORM_SPECIFIC, 0x07, (_, argv) -> {
        DeltaProtocolSound sound = DeltaProtocolSound.values()[(int) argv[0].value];
        DeltaProtocolAudioEngine.drive(new DeltaProtocolAudioEngine.SoundInstance(sound.get()));
    }, new Argument(Argument.Type.SHORT));
}
