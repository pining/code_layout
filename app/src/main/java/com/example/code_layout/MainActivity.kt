package com.example.code_layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.marginTop
import kotlinx.android.synthetic.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        addConstraintLayout()
    }

    fun addConstraintLayout(){
        val constraintLayout = ConstraintLayout(this).apply {
            id = R.id.container
            layoutParams = ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.MATCH_PARENT,
                ConstraintLayout.LayoutParams.MATCH_PARENT)
            setContentView(this)
        }
        ImageView(this).apply {
            id = R.id.header
            layoutParams = ConstraintLayout.LayoutParams(dpTopx(150),dpTopx(100)).apply {
                leftToLeft = R.id.container
                topToTop = R.id.container
                setMargins(dpTopx(10),dpTopx(10),0,0)
            }
            setImageResource(R.drawable.gift)
            scaleType = ImageView.ScaleType.CENTER_CROP
            constraintLayout.addView(this)
        }
        TextView(this).apply {
            id = R.id.title
            layoutParams = ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.MATCH_CONSTRAINT,
                ConstraintLayout.LayoutParams.MATCH_CONSTRAINT).apply{
                leftToRight = R.id.header
                rightToRight = R.id.container
                topToTop = R.id.header
                bottomToBottom = R.id.header
                background = getDrawable(R.color.orange)
                setMargins(dpTopx(10),0,dpTopx(10),0)
            }
            text = "外交部回应美方打压TikTok：不要打开潘多拉的盒子，否则将自食其果"
            setTextColor(getColor(R.color.white))
            textSize = 20f
            constraintLayout.addView(this)
        }
        TextView(this).apply {
            layoutParams = ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.MATCH_CONSTRAINT,
                ConstraintLayout.LayoutParams.MATCH_CONSTRAINT).apply {
                leftToLeft = R.id.header
                rightToRight = R.id.title
                topToBottom = R.id.header
                bottomToBottom = R.id.container
                setMargins(0,dpTopx(10),0,0)
            }
            text = "8月4日，外交部发言人汪文斌表示，有关企业按照市场原则和国际规则在美展开商业活动，遵守美国法律法规，但美方以“莫须有”的罪名进行设限打压，这完全是政治操弄。事实上，美方动用国家机器打压他国企业的行为屡见不鲜。美方务必不要打开潘多拉的盒子,否则将自食其果。我们呼吁美方认真倾听本国和国际社会的理性声音，不要将经济问题政治化，为各国市场主体在美投资经营提供开放、公平、公正、非歧视的营商环境，多做有利于全球经济发展的事。"
            setTextColor(getColor(R.color.black))
            textSize = 20f
            constraintLayout.addView(this)
        }
    }

    fun addRelativeLayout(){
        val relativeLayout = RelativeLayout(this).apply {
            layoutParams = RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT)
            id = R.id.container
            setContentView(this)
        }
        ImageView(this).apply {
            id = R.id.header
            layoutParams = RelativeLayout.LayoutParams(dpTopx(150),dpTopx(100)).apply {
                setMargins(dpTopx(10),dpTopx(10),0,0)
            }
            setImageResource(R.drawable.view)
            scaleType = ImageView.ScaleType.CENTER_CROP
            relativeLayout.addView(this)
        }
        TextView(this).apply {
            layoutParams = RelativeLayout.LayoutParams(0,0).apply {
                addRule(RelativeLayout.RIGHT_OF,R.id.header)
                addRule(RelativeLayout.ALIGN_PARENT_END,R.id.container)
                addRule(RelativeLayout.ALIGN_TOP,R.id.header)
                addRule(RelativeLayout.ALIGN_BOTTOM,R.id.header)
                marginEnd = dpTopx(10)
                background = getDrawable(R.color.green)
            }
            text = "外交部回应美方打压TikTok：不要打开潘多拉的盒子，否则将自食其果"
            setTextColor(getColor(R.color.white))
            textSize = 20f
            relativeLayout.addView(this)
        }
        TextView(this).apply {
            layoutParams = RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,0).apply {
                addRule(RelativeLayout.BELOW,R.id.header)
                addRule(RelativeLayout.ALIGN_PARENT_BOTTOM,R.id.container)
                marginStart = dpTopx(10)
                marginEnd = dpTopx(10)
                setMargins(0,dpTopx(10),0,0)
            }
            text = "8月4日，外交部发言人汪文斌表示，有关企业按照市场原则和国际规则在美展开商业活动，遵守美国法律法规，但美方以“莫须有”的罪名进行设限打压，这完全是政治操弄。事实上，美方动用国家机器打压他国企业的行为屡见不鲜。美方务必不要打开潘多拉的盒子,否则将自食其果。我们呼吁美方认真倾听本国和国际社会的理性声音，不要将经济问题政治化，为各国市场主体在美投资经营提供开放、公平、公正、非歧视的营商环境，多做有利于全球经济发展的事。"
            setTextColor(getColor(R.color.black))
            textSize = 20f
            relativeLayout.addView(this)
        }
    }

    fun addLinearLayout_kotlin(){
        val container = LinearLayout(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT)
            orientation = LinearLayout.VERTICAL
        }.also {
            setContentView(it)
        }
        LinearLayout(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,dpTopx(100))
            orientation = LinearLayout.HORIZONTAL
            background = resources.getDrawable(R.color.orange)
            container.addView(this)
        }.apply {
            ImageView(this@MainActivity).apply {
                layoutParams = LinearLayout.LayoutParams(
                        dpTopx(120),LinearLayout.LayoutParams.MATCH_PARENT)
                setImageResource(R.drawable.gift)
                scaleType = ImageView.ScaleType.CENTER_CROP
                addView(this)
            }
            TextView(this@MainActivity).apply {
                layoutParams = LinearLayout.LayoutParams(
                        0,
                        LinearLayout.LayoutParams.MATCH_PARENT).apply{
                    weight = 1f
                    setMargins(dpTopx(10),dpTopx(10),dpTopx(10),dpTopx(10))
                }
                text = "外交部回应美方打压TikTok：不要打开潘多拉的盒子，否则将自食其果"
                setTextColor(getColor(R.color.white))
                textSize = 20f
                addView(this)
            }
        }
        TextView(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT).apply {
                setMargins(dpTopx(10),dpTopx(50),dpTopx(10),dpTopx(10))
            }
            text = "8月4日，外交部发言人汪文斌表示，有关企业按照市场原则和国际规则在美展开商业活动，遵守美国法律法规，但美方以“莫须有”的罪名进行设限打压，这完全是政治操弄。事实上，美方动用国家机器打压他国企业的行为屡见不鲜。美方务必不要打开潘多拉的盒子,否则将自食其果。我们呼吁美方认真倾听本国和国际社会的理性声音，不要将经济问题政治化，为各国市场主体在美投资经营提供开放、公平、公正、非歧视的营商环境，多做有利于全球经济发展的事。"
            setTextColor(getColor(R.color.black))
            textSize = 20f
            container.addView(this)
        }
    }

    fun dpTopx(dp: Int): Int{
        return (resources.displayMetrics.density * dp).toInt()
    }

    fun addLinearLayout_java(){
        val linearLayout = LinearLayout(this)
        linearLayout.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT)
        linearLayout.orientation = LinearLayout.VERTICAL
        setContentView(linearLayout)
    }
}