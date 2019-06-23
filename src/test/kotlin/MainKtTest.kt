import org.hamcrest.CoreMatchers.equalTo
import org.junit.Assert.assertThat
import org.junit.Test

class MainKtTest {

    @Test
    fun `test textToTranslation case 1`() {
        val text = "{{ order.completed | amLocal | amDateFormat: 'MM/DD/YYYY, h:mm a' }}"
        val expected = "{{ order.completed | amLocal | amDateFormat: 'MM/DD/YYYY, h:mm a' }}"

        assertThat(textToTranslation(text), equalTo(expected))
    }

    @Test
    fun `test textToTranslation case 2`() {
        val text = "Order {{ order.id }}"
        val expected = """{{ 'order' | translate:{'order.id': order.id} }}"""

        assertThat(textToTranslation(text), equalTo(expected))
    }
}
