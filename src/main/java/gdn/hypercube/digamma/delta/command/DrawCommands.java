package gdn.hypercube.digamma.delta.command;

import gdn.hypercube.digamma.delta.core.DeltaProtocolBootSequence;
import gdn.hypercube.digamma.delta.util.DeltaProtocolPortrait;
import gdn.hypercube.epsilon.core.util.Argument;
import gdn.hypercube.epsilon.core.util.EngineCommand;

@SuppressWarnings("unused")
public class DrawCommands {
    EngineCommand EMDS = new EngineCommand(EngineCommand.Type.PLAFORM_SPECIFIC, 0x01, (_, _) -> DeltaProtocolBootSequence.DRAW_MENU = true); /* Enable Menu Draw State */
    EngineCommand DMDS = new EngineCommand(EngineCommand.Type.PLAFORM_SPECIFIC, 0x02, (_, _) -> DeltaProtocolBootSequence.DRAW_MENU = false); /* Disable Menu Draw State */

    EngineCommand SetPortrait = new EngineCommand(EngineCommand.Type.PLAFORM_SPECIFIC, 0x06, (_, argv) -> {
        DeltaProtocolBootSequence.PORTRAIT = DeltaProtocolPortrait.values()[(int)argv[0].value];
    }, new Argument(Argument.Type.SHORT));
}
