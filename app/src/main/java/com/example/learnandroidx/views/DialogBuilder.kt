//package com.example.learnandroidx.views
//
///**
// * @author    yiliyang
// * @date      21-4-25 上午10:04
// * @version   1.0
// * @since     1.0
// */
//import android.app.Activity
//import android.content.Context
//import android.view.LayoutInflater
//import android.view.Window
//import androidx.appcompat.app.AlertDialog
//import androidx.core.view.isVisible
//import androidx.fragment.app.Fragment
//import com.example.learnandroidx.R
//import com.google.android.material.dialog.MaterialAlertDialogBuilder
//
//@DslMarker
//annotation class DslDialog
//
//@DslDialog
//class DialogBuilder(
//    val context: Context,
//    val themeColor: DialogThemeColor,
//    val setup: DialogBuilder.() -> Unit = {}
//) {
//
//    var title: String = ""
//    var contentText: String = ""
//    var positiveText: String = ""
//    var negativeText: String = ""
//    var positiveAction: (() -> Unit)? = null
//    var negativeAction: (() -> Unit)? = null
//    var dismissAction: (() -> Unit)? = null
//    var checkboxText: String? = null
//    var checkBoxCallback: (() -> Unit)? = null
//    var cancelable: Boolean = true
//    private lateinit var dialog: AlertDialog
//
//
//    fun build(): AlertDialog {
//        setup()
//        if (title.isEmpty() || contentText.isEmpty() || positiveText.isEmpty() || negativeText.isEmpty()) {
//            throw IllegalArgumentException("You should fill all mandatory fields in the options")
//        }
//        val options = DialogOptions(
//            title = title,
//            contentText = contentText,
//            backgroundThemeColor = themeColor,
//            positiveText = positiveText,
//            negativeText = negativeText,
//            checkBoxText = checkboxText,
//            checkBoxCallback = checkBoxCallback,
//            positiveAction = positiveAction,
//            negativeAction = negativeAction
//        )
//
//        dialog = setupCustomAlertDialog(options)
//
//        return dialog
//    }
//
//
//    private fun setupCustomAlertDialog(options: DialogOptions): AlertDialog {
//        val layoutBinding = CustomDialogComponentBinding.inflate(LayoutInflater.from(context))
//
//
//        val alertDialog =
//            MaterialAlertDialogBuilder(context, R.style.DialogComponentCustomAlertDialogTheme)
//                .setView(layoutBinding.root)
//                .setCancelable(cancelable)
//                .setOnDismissListener {
//                    dismissAction?.invoke()
//                }
//                .create()
//        alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
//
//
//        layoutBinding.titleText.text = options.title
//        layoutBinding.contentText.text = options.contentText
//
//
//        options.checkBoxCallback?.let { _ ->
//            layoutBinding.hideScreenCheckbox.isVisible = checkboxText?.isNotEmpty() ?: false
//            layoutBinding.hideScreenCheckbox.text = options.checkBoxText
//            layoutBinding.hideScreenCheckbox.isChecked = false
//        } ?: run {
//            layoutBinding.hideScreenCheckbox.isVisible = false
//        }
//
//        layoutBinding.closeButton.isVisible = !cancelable
//        layoutBinding.closeButton.setOnClickListener {
//            alertDialog.dismiss()
//        }
//
//        layoutBinding.negativeAction.text = options.negativeText
//        layoutBinding.negativeAction.setOnClickListener {
//            options.negativeAction?.invoke()
//            alertDialog.dismiss()
//        }
//
//        layoutBinding.positiveAction.text = options.positiveText
//        layoutBinding.positiveAction.setOnClickListener {
//            options.positiveAction?.invoke()
//            options.checkBoxCallback?.invoke()
//            alertDialog.dismiss()
//        }
//
//
//        return alertDialog
//    }
//}
//
//
//data class DialogOptions(
//    val title: String,
//    val contentText: String,
//    val backgroundThemeColor: DialogThemeColor,
//    val positiveText: String,
//    val negativeText: String,
//    var checkBoxText: String? = null,
//    var checkBoxCallback: (() -> Unit)? = null,
//    val positiveAction: (() -> Unit)? = null,
//    val negativeAction: (() -> Unit)? = null,
//)
//
//
//fun Fragment.dialog(setup: DialogBuilder.() -> Unit) {
//    val builder = DialogBuilder(requireContext(), themeColor = DialogThemeColor.Blue, setup = setup)
//    builder.build().show()
//}
//
//fun Activity.dialog(setup: DialogBuilder.() -> Unit) {
//    val builder = DialogBuilder(this, themeColor = DialogThemeColor.Blue, setup = setup)
//    builder.build().show()
//}
//
//fun AlertDialog.dismiss() {
//    if (isShowing) {
//        dismiss()
//    }
//}
//
//sealed class DialogThemeColor {
//    val backgroundColor: Int
//        get() = when (this) {
//            is Blue -> R.color.white
//        }
//
//    val messageTextColor: Int
//        get() = when (this) {
//            is Blue -> android.R.color.black
//        }
//
//    val titleTextColor: Int
//        get() = when (this) {
//            is Blue -> android.R.color.black
//        }
//
//    val positiveTextColor: Int
//        get() = when (this) {
//            is Blue -> R.color.purple_500
//        }
//
//    val negativeTextColor: Int
//        get() = when (this) {
//            is Blue -> R.color.purple_500
//        }
//
//    object Blue : DialogThemeColor()
//}