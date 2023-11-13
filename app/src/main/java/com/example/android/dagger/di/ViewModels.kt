import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.example.android.dagger.di.ActivityScope
import com.example.android.dagger.di.AppComponent
import com.example.android.dagger.settings.SettingsViewModel
import me.tatarka.inject.annotations.Component
import me.tatarka.inject.annotations.Inject
import me.tatarka.inject.annotations.IntoMap
import me.tatarka.inject.annotations.Provides

@ActivityScope
@Inject
class ViewModelFactory(
    private val viewModels: Map<Class<out ViewModel>, Lazy<ViewModel>>
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        viewModels[modelClass]?.value as T
}

@ActivityScope
@Component
abstract class ViewModelComponent(@Component val parent: AppComponent) {
    abstract val viewModelsMap: Map<Class<out ViewModel>, Lazy<ViewModel>>
    abstract val viewModelFactory: ViewModelProvider.Factory

    @Provides
    protected fun viewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory = factory

    @IntoMap
    @Provides
    protected fun settingsViewModel(vm: SettingsViewModel): Pair<Class<out ViewModel>, Lazy<ViewModel>> =
        SettingsViewModel::class.java to lazyOf(vm)

    // Get any ViewModel existing in the kotlin-inject graph automatically constructed
    // with all needed dependencies.
    inline fun <reified VM : ViewModel> get(
        owner: ViewModelStoreOwner
    ) = lazyOf(ViewModelProvider(owner, viewModelFactory)[VM::class.java])

    companion object
}
