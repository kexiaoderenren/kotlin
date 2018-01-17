/*
 * Copyright 2000-2018 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license
 * that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.idea.highlighter.dsl

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.psi.PsiElement
import org.jetbrains.kotlin.descriptors.DeclarationDescriptor
import org.jetbrains.kotlin.idea.highlighter.HighlighterExtension
import org.jetbrains.kotlin.idea.highlighter.KotlinHighlightingColors
import org.jetbrains.kotlin.resolve.calls.model.ResolvedCall

class DslColoringExtension: HighlighterExtension() {
    override fun highlightCall(elementToHighlight: PsiElement, resolvedCall: ResolvedCall<*>): TextAttributesKey? {
        if (!isDsl) {
            return null
        }
        return KotlinHighlightingColors.KEYWORD
    }
}