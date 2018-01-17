/*
 * Copyright 2000-2018 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license
 * that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.idea.highlighter.dsl

import com.intellij.openapi.editor.XmlHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.markup.TextAttributes
import com.intellij.psi.PsiElement
import org.jetbrains.kotlin.descriptors.DeclarationDescriptor
import org.jetbrains.kotlin.idea.highlighter.HighlighterExtension
import org.jetbrains.kotlin.resolve.calls.checkers.DslScopeViolationCallChecker.extractDslMarkerFqNames
import org.jetbrains.kotlin.resolve.calls.model.ResolvedCall
import org.jetbrains.kotlin.resolve.calls.resolvedCallUtil.getImplicitReceivers

class DslColoringExtension : HighlighterExtension() {
    override fun highlightDeclaration(elementToHighlight: PsiElement, descriptor: DeclarationDescriptor): TextAttributesKey? {
        return null
    }

    override fun highlightCall(elementToHighlight: PsiElement, resolvedCall: ResolvedCall<*>): TextAttributesKey? {
        val isDslCall = resolvedCall.getImplicitReceivers().any { it.type.extractDslMarkerFqNames().isNotEmpty() }
        if (!isDslCall) {
            return null
        }
        return HTML_DSL_ATTRIBUTES
    }

    companion object {
        private val HTML_DSL_ATTRIBUTES by lazy {
            TextAttributesKey.createTextAttributesKey(
                    "KOTLIN_DSL::KOTLINX_HTML",
                    TextAttributes.merge(
                            XmlHighlighterColors.HTML_TAG.defaultAttributes,
                            XmlHighlighterColors.HTML_TAG_NAME.defaultAttributes
                    )
            )
        }
    }
}