package me.anadinema.project.boldictio.mapper;

import me.anadinema.project.boldictio.entity.boldictio.BoldictioResponse;
import me.anadinema.project.boldictio.entity.boldictio.Media;
import me.anadinema.project.boldictio.entity.boldictio.Pronunciation;
import me.anadinema.project.boldictio.entity.boldictio.Text;
import me.anadinema.project.boldictio.entity.dictionaryapidev.DictionaryResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class DictionaryApiToBoldictioMapper {

    public BoldictioResponse map(DictionaryResponse dictionaryResponse) {
        BoldictioResponse boldictioResponse = new BoldictioResponse();
        boldictioResponse.setText(createTextResponse(dictionaryResponse));
        boldictioResponse.setMedia(createMediaResponse(dictionaryResponse));
        return boldictioResponse;
    }

    private static Text createTextResponse(DictionaryResponse dictionaryResponse) {
        Text text = new Text();
        text.setWord(dictionaryResponse.getWord());
        text.setMeanings(dictionaryResponse.getMeanings());
        return text;
    }

    private static Media createMediaResponse(DictionaryResponse dictionaryResponse) {
        Media media = new Media();
        media.setImage(null);
        media.setPronunciation(createPronunciationResponse(dictionaryResponse));
        media.setVideo(null);
        return media;
    }

    public static List<Pronunciation> createPronunciationResponse(DictionaryResponse dictionaryResponse) {
        List<Pronunciation> pronunciationList = new ArrayList<Pronunciation>();
        if (dictionaryResponse.getPhonetics() != null)
        {
            dictionaryResponse.getPhonetics().forEach(phonetics -> {
                pronunciationList.add(new Pronunciation(phonetics.getText(), phonetics.getAudio()));
            });
        }
        return pronunciationList;
    }
}
