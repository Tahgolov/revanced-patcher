package app.revanced.patcher.patch.options.types

import app.revanced.patcher.patch.Patch
import app.revanced.patcher.patch.options.PatchOption

/**
 * A [PatchOption] representing a [String].
 *
 * @param key The identifier.
 * @param default The default value.
 * @param title The title.
 * @param description A description.
 * @param required Whether the option is required.
 * @param validator The function to validate the option value.
 *
 * @see PatchOption
 */
class StringPatchOption private constructor(
    key: String,
    default: String?,
    title: String?,
    description: String?,
    required: Boolean,
    validator: (String?) -> Boolean
) : PatchOption<String>(key, default, title, description, required, validator) {
    companion object {
        /**
         * Create a new [StringPatchOption] and add it to the current [Patch].
         *
         * @param key The identifier.
         * @param default The default value.
         * @param title The title.
         * @param description A description.
         * @param required Whether the option is required.
         * @param validator The function to validate the option value.
         * 
         * @return The created [StringPatchOption].
         *
         * @see StringPatchOption
         * @see PatchOption
         */
        fun <T : Patch<*>> T.stringPatchOption(
            key: String,
            default: String? = null,
            title: String? = null,
            description: String? = null,
            required: Boolean = false,
            validator: (String?) -> Boolean = { true }
        ) = StringPatchOption(key, default, title, description, required, validator).also  { options.register(it) }
    }
}
