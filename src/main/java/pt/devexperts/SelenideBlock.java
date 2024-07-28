package pt.devexperts;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Command;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.DownloadOptions;
import com.codeborne.selenide.DragAndDropOptions;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.HighlightOptions;
import com.codeborne.selenide.HoverOptions;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.SetValueOptions;
import com.codeborne.selenide.TypeOptions;
import com.codeborne.selenide.WebElementCondition;
import com.codeborne.selenide.conditions.Text;
import com.codeborne.selenide.files.FileFilter;
import org.jetbrains.annotations.Nullable;
import org.openqa.selenium.By;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Coordinates;

import javax.annotation.Nonnull;
import java.awt.image.BufferedImage;
import java.io.File;
import java.time.Duration;
import java.util.List;


@SuppressWarnings({
        "MethodCount",
        "deprecation",
        "MethodTypeParameterName",
        "PMD.ExcessivePublicCount",
        "PMD.TooManyMethods",
        "PMD.AvoidDollarSigns",
        "PMD.AvoidUncheckedExceptionsInSignatures"
})
public class SelenideBlock implements SelenideElement {

    protected final SelenideElement origin;

    public SelenideBlock(final SelenideElement origin) {
        this.origin = origin;
    }

    @NotNull
    @Override
    public SelenideElement setValue(@Nullable String text) {
        return origin.setValue(text);
    }

    @NotNull
    @Override
    public SelenideElement setValue(SetValueOptions text) {
        return origin.setValue(text);
    }

    @NotNull
    @Override
    public SelenideElement type(CharSequence textToType) {
        return origin.type(textToType);
    }

    @NotNull
    @Override
    public SelenideElement type(TypeOptions typeOptions) {
        return origin.type(typeOptions);
    }

    @NotNull
    @Override
    public SelenideElement val(@Nullable String text) {
        return origin.val(text);
    }

    @NotNull
    @Override
    public SelenideElement val(SetValueOptions options) {
        return origin.val(options);
    }

    @Nullable
    @Override
    public String val() {
        return origin.val();
    }

    @Nonnull
    @Override
    public SelenideElement append(String text) {
        return origin.append(text);
    }

    @NotNull
    @Override
    public SelenideElement paste() {
        return origin.paste();
    }

    @Nonnull
    @Override
    public SelenideElement pressEnter() {
        return origin.pressEnter();
    }

    @Nonnull
    @Override
    public SelenideElement pressTab() {
        return origin.pressTab();
    }

    @NotNull
    @Override
    public SelenideElement unfocus() {
        return origin.unfocus();
    }

    @Nonnull
    @Override
    public SelenideElement pressEscape() {
        return origin.pressEscape();
    }

    @NotNull
    @Override
    public SelenideElement press(CharSequence... keysToPress) {
        return press(keysToPress);
    }

    @Nonnull
    @Override
    public String getText() {
        return origin.shouldBe(Condition.visible).getText();
    }

    @Nonnull
    @Override
    public String getAlias() {
        return origin.getAlias();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return origin.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return origin.findElement(by);
    }

    @Override
    public SearchContext getShadowRoot() {
        return SelenideElement.super.getShadowRoot();
    }

    @Nonnull
    @Override
    public String text() {
        return origin.text();
    }

    @Nonnull
    public static WebElementCondition text(String text) {
        return new Text(text);
    }

    @Nonnull
    @Override
    public String getOwnText() {
        return origin.getOwnText();
    }

    @Nonnull
    @Override
    public String innerText() {
        return origin.innerText();
    }

    @Nonnull
    @Override
    public String innerHtml() {
        return origin.innerHtml();
    }

    @Nullable
    @Override
    public String attr(String attributeName) {
        return origin.attr(attributeName);
    }

    @Nullable
    @Override
    public String name() {
        return origin.name();
    }

    @Nullable
    @Override
    public String getValue() {
        return origin.getValue();
    }

    @Nonnull
    @Override
    public String pseudo(String pseudoElementName, String propertyName) {
        return origin.pseudo(pseudoElementName, propertyName);
    }

    @Nonnull
    @Override
    public String pseudo(String pseudoElementName) {
        return origin.pseudo(pseudoElementName);
    }

    @Nonnull
    @Override
    public SelenideElement selectRadio(String value) {
        return origin.selectRadio(value);
    }

    @Nullable
    @Override
    public String data(String dataAttributeName) {
        return origin.data(dataAttributeName);
    }

    @Nullable
    @Override
    public String getAttribute(String name) {
        return origin.getAttribute(name);
    }

    @Override
    public String getAriaRole() {
        return SelenideElement.super.getAriaRole();
    }

    @Override
    public String getAccessibleName() {
        return SelenideElement.super.getAccessibleName();
    }

    @Override
    public boolean isSelected() {
        return origin.isSelected();
    }

    @Override
    public boolean isEnabled() {
        return origin.isEnabled();
    }

    @Nonnull
    @Override
    public String getCssValue(String propertyName) {
        return origin.getCssValue(propertyName);
    }

    @Override
    public boolean exists() {
        return origin.exists();
    }

    @Override
    public boolean isDisplayed() {
        return origin.isDisplayed();
    }

    @Override
    public Point getLocation() {
        return origin.getLocation();
    }

    @Override
    public Dimension getSize() {
        return origin.getSize();
    }

    @Override
    public Rectangle getRect() {
        return origin.getRect();
    }

    @Override
    public boolean is(WebElementCondition condition) {
        return origin.is(condition);
    }

    @Override
    public boolean is(WebElementCondition webElementCondition, Duration duration) {
        return false;
    }

    @Override
    public boolean has(WebElementCondition condition) {
        return origin.has(condition);
    }

    @Override
    public boolean has(WebElementCondition webElementCondition, Duration duration) {
        return false;
    }

    @Nonnull
    @Override
    public SelenideElement setSelected(boolean selected) {
        return origin.setSelected(selected);
    }

    @Nonnull
    @Override
    public SelenideElement should(WebElementCondition... condition) {
        return origin.should(condition);
    }

    @Nonnull
    @Override
    public SelenideElement should(WebElementCondition condition, Duration timeout) {
        return origin.should(condition, timeout);
    }

    @Nonnull
    @Override
    public SelenideBlock shouldHave(WebElementCondition... condition) {
        return new SelenideBlock(origin.shouldHave(condition));
    }

    @Nonnull
    @Override
    public SelenideBlock shouldHave(WebElementCondition condition, Duration timeout) {
        return new SelenideBlock(origin.shouldHave(condition, timeout));
    }

    @Nonnull
    @Override
    public SelenideBlock shouldBe(WebElementCondition... condition) {
        return new SelenideBlock(origin.shouldBe(condition));
    }

    @Nonnull
    @Override
    public SelenideBlock shouldBe(WebElementCondition condition, Duration timeout) {
        return new SelenideBlock(origin.shouldBe(condition, timeout));
    }

    @Nonnull
    @Override
    public SelenideElement shouldNot(WebElementCondition... condition) {
        return origin.shouldNot(condition);
    }

    @Nonnull
    @Override
    public SelenideElement shouldNot(WebElementCondition condition, Duration timeout) {
        return origin.shouldNot(condition, timeout);
    }

    @Nonnull
    @Override
    public SelenideBlock shouldNotHave(WebElementCondition... condition) {
        return new SelenideBlock(origin.shouldNotHave(condition));
    }

    @Nonnull
    @Override
    public SelenideBlock shouldNotHave(WebElementCondition condition, Duration timeout) {
        return new SelenideBlock(origin.shouldNotHave(condition, timeout));
    }

    @Nonnull
    @Override
    public SelenideBlock shouldNotBe(WebElementCondition... condition) {
        return new SelenideBlock(origin.shouldNotBe(condition));
    }

    @Nonnull
    @Override
    public SelenideBlock shouldNotBe(WebElementCondition condition, Duration timeout) {
        return new SelenideBlock(origin.shouldNotBe(condition, timeout));
    }

    @Nonnull
    @Override
    public String toString() {
        return origin.toString();
    }

    @NotNull
    @Override
    public String describe() {
        return origin.describe();
    }

    @NotNull
    @Override
    public SelenideElement highlight() {
        return origin.highlight();
    }

    @NotNull
    @Override
    public SelenideElement highlight(HighlightOptions highlightOptions) {
        return origin.highlight(highlightOptions);
    }

    @Nonnull
    @Override
    public SelenideElement as(String alias) {
        return origin.as(alias);
    }

    @Nonnull
    @Override
    public SelenideElement parent() {
        return origin.parent();
    }

    @Nonnull
    @Override
    public SelenideElement sibling(int index) {
        return origin.sibling(index);
    }

    @Nonnull
    @Override
    public SelenideElement preceding(int index) {
        return origin.preceding(index);
    }

    @Nonnull
    @Override
    public SelenideElement lastChild() {
        return origin.lastChild();
    }

    @NotNull
    @Override
    public SelenideElement ancestor(String selector) {
        return origin.ancestor(selector);
    }

    @NotNull
    @Override
    public SelenideElement ancestor(String selector, int index) {
        return origin.ancestor(selector, index);
    }

    @Nonnull
    @Override
    public SelenideElement closest(String tagOrClass) {
        return origin.closest(tagOrClass);
    }

    @Nonnull
    @Override
    public SelenideElement find(String cssSelector) {
        return origin.find(cssSelector);
    }

    @Nonnull
    @Override
    public SelenideElement find(String cssSelector, int index) {
        return origin.find(cssSelector, index);
    }

    @Override
    public SelenideElement find(By selector) {
        return origin.find(selector);
    }

    @Nonnull
    @Override
    public SelenideElement find(By selector, int index) {
        return origin.find(selector, index);
    }

    @Nonnull
    @Override
    public SelenideElement $(String cssSelector) {
        return origin.$(cssSelector);
    }

    @Nonnull
    @Override
    public SelenideElement $(String cssSelector, int index) {
        return origin.$(cssSelector, index);
    }

    @Nonnull
    @Override
    public SelenideElement $(By selector) {
        return origin.$(selector);
    }

    @Nonnull
    @Override
    public SelenideElement $(By selector, int index) {
        return origin.$(selector, index);
    }

    @Nonnull
    @Override
    public SelenideElement $x(String xpath) {
        return origin.$x(xpath);
    }

    @Nonnull
    @Override
    public SelenideElement $x(String xpath, int index) {
        return origin.$x(xpath, index);
    }

    @Nonnull
    @Override
    public ElementsCollection findAll(String cssSelector) {
        return origin.findAll(cssSelector);
    }

    @Nonnull
    @Override
    public ElementsCollection findAll(By selector) {
        return origin.findAll(selector);
    }

    @Nonnull
    @Override
    public ElementsCollection $$(String cssSelector) {
        return origin.$$(cssSelector);
    }

    @Nonnull
    @Override
    public ElementsCollection $$(By selector) {
        return origin.$$(selector);
    }

    @Nonnull
    @Override
    public ElementsCollection $$x(String xpath) {
        return origin.$$x(xpath);
    }

    @Nonnull
    @Override
    public File uploadFromClasspath(String... fileName) {
        return origin.uploadFromClasspath(fileName);
    }

    @Nonnull
    @Override
    public File uploadFile(File... file) {
        return origin.uploadFile(file);
    }

    @Override
    public void selectOption(int index, int... otherIndexes) {
        origin.selectOption(index);
    }

    @Override
    public void selectOption(String text, String... otherTexts) {
        origin.selectOption(text);
    }

    @Override
    public void selectOptionContainingText(String text, String... otherTexts) {
        origin.selectOptionContainingText(text);
    }

    @Override
    public void selectOptionByValue(String value, String... otherValues) {
        origin.selectOptionByValue(value);
    }

    @Nonnull
    @Override
    public SelenideElement getSelectedOption() throws NoSuchElementException {
        return origin.getSelectedOption();
    }

    @Nonnull
    @Override
    public ElementsCollection getSelectedOptions() {
        return origin.getSelectedOptions();
    }

    @NotNull
    @Override
    public ElementsCollection getOptions() {
        return origin.getOptions();
    }

    @Nullable
    @Override
    public String getSelectedOptionValue() {
        return origin.getSelectedOptionValue();
    }

    @Nullable
    @Override
    public String getSelectedOptionText() {
        return origin.getSelectedOptionText();
    }

    @Nonnull
    @Override
    public SelenideBlock scrollTo() {
        return new SelenideBlock(origin.scrollTo());
    }

    @Nonnull
    @Override
    public SelenideBlock scrollIntoView(boolean alignToTop) {
        return new SelenideBlock(origin.scrollIntoView(alignToTop));
    }

    @Nonnull
    @Override
    public SelenideBlock scrollIntoView(String scrollIntoViewOptions) {
        return new SelenideBlock(origin.scrollIntoView(scrollIntoViewOptions));
    }

    @Nonnull
    @Override
    public File download() {
        return origin.download();
    }

    @Nonnull
    @Override
    public File download(long timeout) {
        return origin.download(timeout);
    }

    @Nonnull
    @Override
    public File download(FileFilter fileFilter) {
        return origin.download(fileFilter);
    }

    @Nonnull
    @Override
    public File download(long timeout, FileFilter fileFilter) {
        return origin.download(timeout, fileFilter);
    }

    @Nonnull
    @Override
    public File download(DownloadOptions options) {
        return origin.download(options);
    }

    @Nonnull
    @Override
    public String getSearchCriteria() {
        return origin.getSearchCriteria();
    }

    @Nonnull
    @Override
    public WebElement toWebElement() {
        return origin.toWebElement();
    }

    @Nonnull
    @Override
    public WebElement getWrappedElement() {
        return origin.getWrappedElement();
    }

    @NotNull
    @Override
    public SelenideElement cached() {
        return origin.cached();
    }

    @Override
    public SelenideElement click(ClickOptions clickOption) {
        return origin.click(clickOption);
    }

    public void click(int duration) {
        this.origin.shouldHave(Condition.visible, Duration.ofSeconds(duration)).click();
    }

    public void click(int duration, WebElementCondition condition) {
        this.origin.shouldHave(condition, Duration.ofSeconds(duration)).click();
    }

    @Override
    public void click() {
        this.origin.shouldHave(Condition.visible).click();
    }

    @Override
    public void submit() {
        this.origin.submit();
    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {
        this.origin.sendKeys(keysToSend);
    }

    public void sendKeysSequentially(String text) {
        for (int i = 0; i < text.length(); i++) {
            this.origin.sendKeys(String.valueOf(text.charAt(i)));
        }
    }

    @Override
    public void clear() {
        this.origin.clear();
    }

    @Override
    public String getTagName() {
        return this.origin.getTagName();
    }

    @Override
    public String getDomProperty(String name) {
        return SelenideElement.super.getDomProperty(name);
    }

    @Override
    public String getDomAttribute(String name) {
        return SelenideElement.super.getDomAttribute(name);
    }

    @Nonnull
    @Override
    public SelenideElement contextClick() {
        return this.origin.contextClick();
    }

    @Nonnull
    @Override
    public SelenideElement doubleClick() {
        return this.origin.doubleClick();
    }

    @NotNull
    @Override
    public SelenideElement doubleClick(ClickOptions clickOption) {
        return origin.doubleClick(clickOption);
    }

    @Nonnull
    @Override
    public SelenideElement hover() {
        return this.origin.hover();
    }

    @NotNull
    @Override
    public SelenideElement hover(HoverOptions options) {
        return origin.hover(options);
    }

    @NotNull
    @Override
    public SelenideElement dragAndDrop(DragAndDropOptions options) {
        return origin.dragAndDrop(options);
    }

    @Override
    public <T> T execute(Command<T> command) {
        return this.origin.execute(command);
    }

    @Override
    public <ReturnType> ReturnType execute(Command<ReturnType> command, Duration timeout) {
        return origin.execute(command, timeout);
    }

    @Override
    public boolean isImage() {
        return this.origin.isImage();
    }

    @Nullable
    @Override
    public File screenshot() {
        return this.origin.screenshot();
    }

    @Nullable
    @Override
    public BufferedImage screenshotAsImage() {
        return this.origin.screenshotAsImage();
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return this.origin.getScreenshotAs(target);
    }

    @Override
    public WebDriver getWrappedDriver() {
        return this.origin.getWrappedDriver();
    }

    @Override
    public Coordinates getCoordinates() {
        return this.origin.getCoordinates();
    }
}

