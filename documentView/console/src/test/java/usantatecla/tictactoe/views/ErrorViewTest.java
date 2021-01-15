package usantatecla.tictactoe.views;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.utils.Console;
import usantatecla.tictactoe.types.Error;

import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

@ExtendWith(MockitoExtension.class)
public class ErrorViewTest {

    @Mock
    private Error error;

    @InjectMocks
    private ErrorView errorView;

    @Mock
    private Console console;

    @Captor
    private ArgumentCaptor<String> captor;

    @BeforeEach
    void before() {
        openMocks(this);
    }

    @Test
    void testGivenNewGameViewWhenWriteNullErrorThenNeverPrint() {
        try (MockedStatic console = mockStatic(Console.class)) {
            when(this.error.isNull()).thenReturn(true);
            console.when(Console::getInstance).thenReturn(this.console);
            this.errorView.writeln();
            verify(this.console, never()).writeln(anyString());
        }
    }
    //TODO DEBERIA FUNCIONAR
    /*@Test
    void testGivenNewGameViewWhenWriteNotNullErrorThenPrintErrorMessage() {
        try (MockedStatic console = mockStatic(Console.class)) {
            when(this.error.isNull()).thenReturn(false);
            when(this.error.ordinal()).thenReturn(0);
            console.when(Console::getInstance).thenReturn(this.console);
            this.errorView.writeln();
            verify(this.console).writeln(captor.capture());
            assertThat(captor.getValue(), is("The square is not empty"));
        }
    }*/

}
