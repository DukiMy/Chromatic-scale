import javax.sound.midi.*;

public class ChromaticScale {

    public static void main(String[] args) {

        try {

            Synthesizer synth = MidiSystem.getSynthesizer();
            synth.open();
            MidiChannel[] channels = synth.getChannels();
            int volume = 100;
            int duration = 1000; // Duration of each note in milliseconds

            for (int note = 60; note <= 72; note++) {

                System.out.printf("note: %d\n", note);
                channels[0].noteOn(note, volume);

                Thread.sleep(duration);

                channels[0].noteOff(note);
            }

            synth.close();

        } catch (MidiUnavailableException | InterruptedException e) {

            e.printStackTrace();

        }
    }
}