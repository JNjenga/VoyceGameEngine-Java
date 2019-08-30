#version 300 core
precision mediump float;

uniform sampler2D frag_tex;
in vec2 frag_UV;
in vec4 frag_Color;

out vec4 out_color;




void main(){
    out_color = frag_Color * texture(frag_tex,frag_UV.st);
}