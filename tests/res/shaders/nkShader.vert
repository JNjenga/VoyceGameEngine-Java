#version 150

in vec2 in_pos;
in vec2 in_texCoord;
in vec4 in_color;

out vec2 frag_UV;
out vec4 frag_Color;

uniform mat4 p_mat;

void main(){
    frag_UV = in_texCoord;
    frag_Color = in_color;
    gl_Position = p_mat * vec4(in_pos.xy,0,1);
}