#version 330 core
layout (location = 0) in vec3 aPos;
layout (location = 1) in vec2 aTexCoord;

out vec2 TexCoord;
uniform mat4 m_mat = mat4(1.0);
uniform mat4 p_mat = mat4(1.0);
void main()
{
    gl_Position = p_mat * m_mat * vec4(aPos, 1.0);
     TexCoord = aTexCoord;
}